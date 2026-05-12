class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        if(initialColor == color) return image;

        int m= image.length;
        int n= image[0].length;

        Queue<Integer> queue= new ArrayDeque<>(); 
        queue.add(sr*n + sc);
        image[sr][sc] = color;

        while(!queue.isEmpty()){
            int curr=queue.poll();
            int r=curr/n;
            int c= curr%n;

            if(validEdge(image,m,n,r,c+1,initialColor)){
                queue.add(r*n +c+1);
                image[r][c+1]=color;
            }
            if(validEdge(image,m,n,r,c-1,initialColor)){
                queue.add(r*n +c-1);
                image[r][c-1]=color;
            }
            if(validEdge(image,m,n,r+1,c,initialColor)){
                queue.add((r+1)*n +c);
                image[r+1][c]=color;
            }
            if(validEdge(image,m,n,r-1,c,initialColor)){
                queue.add((r-1)*n +c);
                image[r-1][c]=color;
            }  
        }
        return image;
    }

    private boolean validEdge(int image[][], int m, int n, int i,int j,int initialColor){
        return i>=0 && i<m && j>=0 && j<n && image[i][j]==initialColor;
    }
}