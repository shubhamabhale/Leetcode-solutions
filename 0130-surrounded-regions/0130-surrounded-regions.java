class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Mark 'O' cells connected to the borders as 'p'
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }

        for (int i = 0; i < cols; i++) {
            dfs(board, 0, i);
            dfs(board, rows - 1, i);
        }

        // Convert marked 'p' cells to 'O' and 'O' cells to 'X'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'p') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'p'; // Mark it as 'p' (not surrounded by 'X')

        // Recursively visit adjacent cells
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
