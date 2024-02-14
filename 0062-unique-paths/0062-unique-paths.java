class Solution {
    public int recurse(int[][] dp, int x, int y, int m, int n) {
        if (x < 1 || y < 1 || x > m || y > n) {
            return 0;
        }
        if(x==m && y==n) 
        {
            return 1;
        }
        if (dp[x][y] != 0)
            return dp[x][y];

        int right = recurse(dp, x + 1, y, m, n);
        int left = recurse(dp, x, y + 1, m, n);
        dp[x][y] =right + left;

        return dp[x][y];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int[] x : dp)
            Arrays.fill(x, 0);

        return  recurse(dp, 1, 1, m, n);
    }
}
