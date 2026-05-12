class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialColor=image[sr][sc];
        if(initialColor == color) return image;

        int m= image.length;
        int n= image[0].length;
        boolean[] visited= new boolean[m*n];

        Queue<Integer> queue= new ArrayDeque<>(); 
        visited[sr*n+sc]=true;
        queue.add(sr*n + sc);

        while(!queue.isEmpty()){
            int curr=queue.poll();
            int r=curr/n;
            int c= curr%n;
            image[r][c]=color;
            if(validEdge(image,m,n,r,c+1,visited,initialColor)){
                queue.add(r*n +c+1);
                visited[r*n+c+1]=true;
            }
            if(validEdge(image,m,n,r,c-1,visited,initialColor)){
                queue.add(r*n +c-1);
                visited[r*n +c-1]=true;
            }
            if(validEdge(image,m,n,r+1,c,visited,initialColor)){
                queue.add((r+1)*n +c);
                visited[(r+1)*n +c]=true;
            }
            if(validEdge(image,m,n,r-1,c,visited,initialColor)){
                queue.add((r-1)*n +c);
                visited[(r-1)*n +c]=true;
            }  
        }
        return image;
    }

    private boolean validEdge(int image[][], int m, int n, int i,int j, boolean[] visited,int initialColor){
        if(i>= m || i<0 || j>=n || j<0) return false;
        return !visited[i*n + j] && image[i][j]==initialColor;
    }
}