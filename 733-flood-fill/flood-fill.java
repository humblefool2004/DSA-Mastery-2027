class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        if(initialColor == color) return image;

        int m= image.length;
        int n= image[0].length;

        Queue<Integer> queue= new ArrayDeque<>(); 
        queue.add(sr*n + sc);

        while(!queue.isEmpty()){
            int curr=queue.poll();
            int r=curr/n;
            int c= curr%n;
            image[r][c]=color;
            if(validEdge(image,m,n,r,c+1,initialColor)){
                queue.add(r*n +c+1);
            }
            if(validEdge(image,m,n,r,c-1,initialColor)){
                queue.add(r*n +c-1);
            }
            if(validEdge(image,m,n,r+1,c,initialColor)){
                queue.add((r+1)*n +c);
            }
            if(validEdge(image,m,n,r-1,c,initialColor)){
                queue.add((r-1)*n +c);
            }  
        }
        return image;
    }

    private boolean validEdge(int image[][], int m, int n, int i,int j,int initialColor){
        if(i>= m || i<0 || j>=n || j<0) return false;
        return image[i][j]==initialColor;
    }
}