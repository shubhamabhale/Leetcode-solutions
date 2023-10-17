class Solution {
    public void solve(char[][] board) {
        if(board.length==0)
            return;
        
        char[][] visited = new char[board.length][board[0].length];
        Arrays.stream(visited).forEach(x-> Arrays.fill(x, 'n'));
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') { 
                dfs(board, visited, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, visited, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, visited, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, visited, board.length - 1, i);
            }
        }
       
        for(int i=0;i<board.length;i++ ){
            for(int j=0;j<board[0].length;j++) {
                
                if(board[i][j]=='p'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
        return;
        
    }
    
    public void dfs(char[][] board, char[][] visited, int row, int col) {
        if(row<0 || col<0 || row>= board.length || col>= board[0].length || visited[row][col] =='v' ) {
            return;
        }
        
        visited[row][col]='v';
        if(board[row][col]=='O') {
            board[row][col]='p';
            dfs( board, visited, row+1, col);
            dfs( board, visited, row-1, col);
            dfs( board, visited, row, col+1);
            dfs( board, visited, row, col-1);
            
        }
        return;
    }
}