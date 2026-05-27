class Solution {
    private int dir[][]={
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };

    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n= grid[0].length;
        boolean visited[][]= new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i,int j){
        for(int[] d : dir){
            int ni=d[0] + i;
            int nj= d[1]+ j;
            if(ni>=0 && ni<grid.length && nj>=0 && nj<grid[0].length && grid[ni][nj]=='1' && !visited[ni][nj]){
                visited[ni][nj]=true;
                dfs(grid,visited,ni,nj);
            }
        }
    }
}