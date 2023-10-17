class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length==0)
                return ;
        for(int i=0;i<rooms.length;i++) {
            for(int j=0;j<rooms[0].length;j++) {
                if(rooms[i][j]==0) {
                    dfs(rooms, i, j,0);
                }
            }
        }
        
    }
    public void dfs(int[][] rooms, int row, int col, int distance) {
        if (row<0 || col<0 ||row>=rooms.length || col>=rooms[0].length  || rooms[row][col]==-1 ) 
            return ;
        
        if(rooms[row][col]<=distance && distance !=0) {
            return;
        }
		// Set the cell to closest distance
        rooms[row][col] = distance;
		// Do DFS over all its neighbours
        dfs(rooms, row-1, col, distance+1);
        dfs(rooms, row, col+1, distance+1);
        dfs(rooms, row+1, col, distance+1);
        dfs(rooms, row, col-1, distance+1);
    }
}