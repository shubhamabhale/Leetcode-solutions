class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;

        // Traverse the four boundaries and mark connected components
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid);
            }
            if (grid[i][cols - 1] == 1) {
                dfs(i, cols - 1, grid);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1) {
                dfs(0, j, grid);
            }
            if (grid[rows - 1][j] == 1) {
                dfs(rows - 1, j, grid);
            }
        }

        // Count remaining enclaves
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int row, int col, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 0) {
            return;
        }

        grid[row][col] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int newRow = row + dr[k];
            int newCol = col + dc[k];
            dfs(newRow, newCol, grid);
        }
    }
}
