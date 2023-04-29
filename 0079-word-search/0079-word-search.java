class Solution {
    public boolean recurse(char[][] board, String word,int index, boolean[][] visited, int row, int col)
    {
        int n = board.length, m = board[0].length;
        
        if(row<0 || row>=n)
            return false;
        if(col<0 || col>=m || visited[row][col])
            return false;
        if(index==word.length()-1 && word.charAt(index)==board[row][col])
            return true;
        
        visited[row][col] = true;
        boolean left=false, right=false, top=false, down=false;
        if(word.charAt(index) == board[row][col])
        {
            down = recurse(board, word, index+1, visited, row + 1, col);
            right = recurse(board, word, index+1, visited, row, col+1);
            left = recurse(board, word, index+1, visited, row, col-1);
            top = recurse(board, word, index+1, visited, row - 1, col);
        }
        visited[row][col]=false;
        return down || right|| left|| top;
    }
    public boolean exist(char[][] board, String word) {
        if(board.length==0)
            return false;
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(recurse(board, word, 0, new boolean[board.length][board[0].length], i,j))
                {
                    return true;
                }
            }
        }
        return false;
    }
}