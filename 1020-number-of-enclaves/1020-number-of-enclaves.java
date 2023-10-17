class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Arrays.stream(visited).forEach(x->Arrays.fill(x,0));
        int x=0;
        for(int i=0;i<grid.length;i++) 
        {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) x++; 
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1) {
                     if(grid[i][j]==1){
                         dfs(i,j,visited,grid);
                     }
                }
            }
        }
        return x-ans;
    }
    int ans =0;
    public int dfs(int row, int col, int[][] visited,int[][] grid) {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || visited[row][col]==1) {
            return 0;
        }
        
        visited[row][col] =1;
        if(grid[row][col]==1) {
            ans++;
            dfs(row+1,col, visited, grid);
            dfs(row-1,col, visited, grid);
            dfs(row,col+1, visited, grid);
            dfs(row,col-1, visited, grid);
        }
        return 0;
    }
}