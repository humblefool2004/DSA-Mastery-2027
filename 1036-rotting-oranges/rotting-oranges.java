class Solution {
    private int[][] dir= new int[][]{
        {-1,0},
        {0,-1},
        {1,0},
        {0,1}
    };

    private int fresh = 0;
    private int minutes = 0;

    public int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2) queue.offer(grid[0].length*i + j);
            }
        }
        findMins(grid, queue);
        return fresh == 0 ? minutes : -1;
    }

    private void findMins(int[][] grid, Queue<Integer> queue){
        if(fresh==0 || queue.isEmpty()) return;
        int n= queue.size();
        for(int k=0;k<n && fresh>0;k++){
            int curr=queue.poll();
            int i = curr / grid[0].length;
            int j = curr % grid[0].length;
            for(int d[] : dir){
                int ni= i+d[0];
                int nj= j+d[1];
                if(ni>=0 && ni<grid.length && nj >=0 && nj<grid[0].length && grid[ni][nj]==1){
                    queue.offer(ni* grid[0].length + nj);
                    grid[ni][nj]=2;
                    fresh--;
                }
            }
        }
        minutes++;
        findMins(grid,queue);
    }
}