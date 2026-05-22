class Solution {
    private int[][] dir= new int[][]{
        {-1,0},
        {0,-1},
        {1,0},
        {0,1}
    };

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        int fresh=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1) 
                    fresh++;
                else if(grid[i][j]==2) 
                    queue.offer(new int[]{i,j});
            }
        }
        int minutes=0;

        while(!queue.isEmpty() && fresh > 0){
            int size= queue.size();

            for(int k=0;k<size;k++){
                int[] curr= queue.poll();
                for(int[] d : dir){
                    int i= curr[0] + d[0];
                    int j= curr[1] + d[1];
                    if(i>=0 && i<rows && j>=0 && j<cols  && grid[i][j]==1){
                        grid[i][j]=2;
                        fresh--;
                        queue.offer(new int[]{i,j});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}