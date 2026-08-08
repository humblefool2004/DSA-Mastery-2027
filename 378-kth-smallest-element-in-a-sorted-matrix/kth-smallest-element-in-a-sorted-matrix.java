class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n= matrix.length;
        PriorityQueue<int[]> pq=  new PriorityQueue<>((a,b)-> a[2]-b[2]);
        
        for(int i=0;i<n;i++){
            pq.offer(new int[]{i,0,matrix[i][0]});
        }

        while(k-- > 1){
            int curr[]= pq.poll();
            int r=curr[0];
            int c= curr[1];
            if(c+1<n){
                pq.offer(new int[]{r,c+1,matrix[r][c+1]});
            }
        }
        return pq.peek()[2];
    }
}