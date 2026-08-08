class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=  new PriorityQueue<>((a,b)-> b-a);
        int n= matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(pq.size()<k) pq.offer(matrix[i][j]); 
                else if(pq.size()==k && pq.peek() > matrix[i][j]){
                    pq.poll();
                    pq.offer(matrix[i][j]); 
                }
                               
            }
        }
        return pq.peek();
    }
}