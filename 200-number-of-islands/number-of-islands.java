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
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i,int j){
        for(int[] d : dir){
            int ni=d[0] + i;
            int nj= d[1]+ j;
            if(ni>=0 && ni<grid.length && nj>=0 && nj<grid[0].length && grid[ni][nj]=='1'){
                grid[ni][nj]='2';
                dfs(grid,ni,nj);
            }
        }
    }
}