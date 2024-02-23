import java.util.*;

class Solution {
    class Pair {
        int dest;
        int cost;

        Pair(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, HashSet<Pair>> hmap = new HashMap<>();
        
        for(int[] time: times){
            Pair p = new Pair(time[1], time[2]);
            HashSet<Pair> temp = hmap.getOrDefault(time[0], new HashSet<>());
            temp.add(p);
            hmap.put(time[0], temp);
        }
        
        Queue<Integer> que = new LinkedList<>();
        
        que.add(k);
        int ans= Integer.MIN_VALUE;
        int[] visited = new int[n+1];
        
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[k]=0;
        
        while (!que.isEmpty()) {
            int current = que.poll();
            if(!hmap.containsKey(current))
                continue;
            HashSet<Pair> neighbors = hmap.getOrDefault(current, new HashSet<>());
            for (Pair p : neighbors) {
                int time = visited[current] + p.cost;
                if (visited[p.dest] > time) {
                    visited[p.dest] = time;
                    que.add(p.dest);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, visited[i]);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
