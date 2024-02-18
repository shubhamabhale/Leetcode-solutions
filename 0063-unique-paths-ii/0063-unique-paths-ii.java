class Solution {
    int[][] dp;
    public int dfs(int[][] grid, int row, int col){
        int m = grid.length, n = grid[0].length;
        if(row>m-1 || col>n-1)
            return 0;
        if(grid[row][col]==1)
            return 0;
        if(dp[row][col]!=0)
            return dp[row][col];
        if(row==m-1 && col==n-1){
            return 1;
        }

        
        dp[row][col] = dfs(grid, row+1, col)+dfs(grid,row, col+1);
        return dp[row][col];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0)
            return 0;
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        return dfs(obstacleGrid, 0, 0);
    }
}