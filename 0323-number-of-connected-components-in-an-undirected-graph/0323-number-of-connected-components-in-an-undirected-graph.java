class Solution {
    
    public void dfs(HashMap<Integer, HashSet<Integer>> adjList, boolean[] visited, int curr){
        visited[curr] = true;
        
        HashSet<Integer> neighbours = adjList.get(curr);
        if(neighbours==null)
            return;
        for(int neighbour: neighbours){
            if(!visited[neighbour]){
                dfs(adjList, visited, neighbour);
            }
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        
        HashMap<Integer, HashSet<Integer>> hmap = new HashMap<>();
        
        for(int[] edge: edges){
            HashSet<Integer> temp = hmap.getOrDefault(edge[0], new HashSet<>());
            temp.add(edge[1]);
            hmap.put(edge[0], temp);
                
            HashSet<Integer> temp1 = hmap.getOrDefault(edge[1], new HashSet<>());
            temp1.add(edge[0]);
            hmap.put(edge[1], temp1);
        }
        int ans =0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                ans++;
                dfs(hmap, visited, i);
            }
        }
        return ans;
    }
}