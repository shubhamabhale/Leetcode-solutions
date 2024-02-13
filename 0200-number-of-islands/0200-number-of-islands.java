class Solution {
    int ans=0;
    public void dfs(char[][] grid, int[][] visited, int x, int y)
    {
        if(x<0 || y<0 || x>=grid.length ||y>= grid[0].length)
            return;
        
        if(visited[x][y]==1)
            return;
        
        visited[x][y]=1;
        if(grid[x][y]=='1')
        {  
            grid[x][y] = 'p';
            dfs(grid,visited,x+1,y);
            dfs(grid,visited,x,y+1);
            dfs(grid,visited,x-1,y); 
            dfs(grid,visited,x,y-1);
        }
    }
    public int numIslands(char[][] grid) {
        if(grid.length==0)
            return 0;
        int[][] visited = new int[grid.length][grid[0].length];

        Arrays.stream(visited).forEach(x -> Arrays.fill(x,0));
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid,visited,i,j);
                    ans++;
                }
            }
        }

        return ans;
    }
}