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
        // Create adjacency list
        Map<Integer, List<Pair>> adj = new HashMap<>();
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(dest, travelTime));
        }

        // Initialize signalReceivedAt array
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        // Add source node to the queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        signalReceivedAt[k] = 0;

        // BFS traversal
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (!adj.containsKey(currNode)) continue;
            for (Pair edge : adj.get(currNode)) {
                int neighborNode = edge.dest;
                int arrivalTime = signalReceivedAt[currNode] + edge.cost;
                if (arrivalTime < signalReceivedAt[neighborNode]) {
                    signalReceivedAt[neighborNode] = arrivalTime;
                    queue.add(neighborNode);
                }
            }
        }

        // Find maximum signal arrival time
        int maxSignalTime = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxSignalTime = Math.max(maxSignalTime, signalReceivedAt[i]);
        }

        // Check if any node is unreachable
        if (maxSignalTime == Integer.MAX_VALUE) return -1;
        return maxSignalTime;
    }
}
