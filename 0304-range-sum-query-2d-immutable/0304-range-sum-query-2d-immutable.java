class NumMatrix {
     int[][] dp;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dp  = new int[m+1][n+1];
      

         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + matrix[i][j];
            }
        }
        for(int[] x : dp)
        System.out.println(Arrays.toString(x));
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        System.out.println(dp[row2][col2] + " " + dp[row1][col1]);
       
        return dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + dp[row1][col1];   
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */