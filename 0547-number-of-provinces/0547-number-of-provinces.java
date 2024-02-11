class Solution {
    public void dfs(int[][] isConnected, boolean[] visited, int curr){
        visited[curr] =true;
        
        for(int j =0;j<isConnected.length;j++)
        {
            if(isConnected[curr][j]==1 && visited[j]==false){
                dfs(isConnected, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        boolean[] visited= new boolean[n];
        int ans =0;
            for(int i=0;i<n;i++)
            {
                if(!visited[i])
                {
                    dfs(isConnected, visited, i);
                    ans++;
                }
            }
        return ans;
    }
}