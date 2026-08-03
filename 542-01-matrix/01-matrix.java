class Solution {

    private boolean visited[];

    public int[][] updateMatrix(int[][] mat) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        int m=mat.length;
        int n= mat[0].length;
        visited= new boolean[m*n];
        for(int i=0;i<m*n;i++){
            if(mat[i/n][i%n]==0){
                queue.offer(i);
                visited[i]=true;
            }
        }

        int k=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int a=queue.poll();
                int r=a/n;
                int c=a%n;
                if(mat[r][c]==1) mat[r][c]=k;

                //up
                if(r!=0 && !visited[(r-1)*n +c]){
                    visited[(r-1)*n +c]=true;
                    queue.offer((r-1)*n +c);
                }
                //down
                if(r!=m-1 && !visited[(r+1)*n +c] ){
                    visited[(r+1)*n +c]=true;
                    queue.offer((r+1)*n +c);
                }
                //left
                if(c!=0 && !visited[r*n + c-1] ){
                    visited[r*n + c-1]=true;
                    queue.offer(r*n + c-1);
                }
                //right
                if(c!=n-1 && !visited[r*n +c+1] ){
                    visited[r*n +c+1]=true;
                    queue.offer(r*n +c+1);
                }
            }
            k++;
        }
        return mat;
    }
}