//using dfs
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color,int initialColor){
        if(r<0 || r>=image.length || c>=image[0].length || c<0 || image[r][c]!=initialColor) return;
        image[r][c]=color;
        int dir[][]= {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };
        for(int d[] : dir){
            int nr=r + d[0];
            int nc=c + d[1];
            dfs(image,nr,nc,color,initialColor);
        }
    }
}

// using bfs
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int initialColor=image[sr][sc];
//         if(initialColor == color) return image;

//         int m= image.length;
//         int n= image[0].length;

//         Queue<Integer> queue= new ArrayDeque<>(); 
//         queue.add(sr*n + sc);
//         image[sr][sc] = color;
        
//         int[][] dir = {
//             {0, 1},
//             {0, -1},
//             {1, 0},
//             {-1, 0}
//         };

//         while(!queue.isEmpty()){
//             int curr=queue.poll();
//             int r=curr/n;
//             int c= curr%n;

//             for(int[] d : dir) {
//                 int nr = r + d[0];
//                 int nc = c + d[1];
//                 if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==initialColor) {
//                     queue.add(nr * n + nc);
//                     image[nr][nc] = color;
//                 }
//             }  
//         }
//         return image;
//     }
// }