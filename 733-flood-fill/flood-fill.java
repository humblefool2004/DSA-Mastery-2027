class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        if(initialColor == color) return image;

        int m= image.length;
        int n= image[0].length;

        Queue<Integer> queue= new ArrayDeque<>(); 
        queue.add(sr*n + sc);
        image[sr][sc] = color;
        
        int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        while(!queue.isEmpty()){
            int curr=queue.poll();
            int r=curr/n;
            int c= curr%n;

            for(int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                if(valid(image, m, n, nr, nc, initialColor)) {
                    queue.add(nr * n + nc);
                    image[nr][nc] = color;
                }
            }  
        }
        return image;
    }

    private boolean valid(int image[][], int m, int n, int i,int j,int initialColor){
        return i>=0 && i<m && j>=0 && j<n && image[i][j]==initialColor;
    }
}