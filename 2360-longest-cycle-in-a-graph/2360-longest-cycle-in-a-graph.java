class Solution {
    int ans =-1;
    public void dfs(int[] edges, int idx, boolean[] visited, HashMap<Integer, Integer> hmap) {
        
        visited[idx] = true;
        int neighbour = edges[idx];
        
        if(neighbour!=-1 && !visited[neighbour]){
            hmap.put(neighbour, hmap.get(idx)+1);
            dfs(edges, neighbour, visited, hmap);
        }
        else if(neighbour!=-1 && hmap.containsKey(neighbour)){
            ans = Math.max(ans, hmap.get(idx)-hmap.get(neighbour)+1);
        }
    }
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
        boolean[] visited = new boolean[n];
        
        
        for(int i=0;i<n;i++)
        {
            if(!visited[i]){
                HashMap<Integer, Integer> hmap = new HashMap<>();
                hmap.put(i, 1);
                dfs(edges, i, visited, hmap);
            }
        }
        
        return ans;
    }
}