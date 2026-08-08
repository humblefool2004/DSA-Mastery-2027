class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n= matrix.length;
        PriorityQueue<int[]> pq=  new PriorityQueue<>((a,b)-> a[2]-b[2]);
        boolean visited[][]= new boolean[n][n];
        
        pq.offer(new int[]{0,0,matrix[0][0]});
        visited[0][0]=true;
        for(int i=0;i<k-1;i++){
            int arr[]= pq.poll();
            int r= arr[0];
            int c= arr[1];
            
            if(r+1 <n && !visited[r+1][c]){
                pq.offer(new int[]{r+1,c,matrix[r+1][c]});
                visited[r+1][c]=true;
            }
            if(c+1<n && !visited[r][c+1]){
                pq.offer(new int[]{r,c+1,matrix[r][c+1]});
                visited[r][c+1]=true;
            }
            
        }
        return pq.peek()[2];
    }
}