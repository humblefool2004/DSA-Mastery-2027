//binary search
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n=matrix.length;
        int low= matrix[0][0];
        int high=matrix[n-1][n-1];
        
        while(low<high){
            int mid=low+ (high-low)/2;
            int count=0;
            for(int i=0;i<n;i++){
                count+= count(matrix[i],mid);
            }
            if(count<k){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }

    private int count(int[] row, int mid){
        int low=0;
        int high=row.length;
        while(low<high){
            int m= low+ (high-low)/2;
            if(row[m] <=mid){
                low=m+1;
            }else{
                high=m;
            }
        }
        return low;
    }
}

//kway merge
// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         int n= matrix.length;
//         PriorityQueue<int[]> pq=  new PriorityQueue<>((a,b)-> a[2]-b[2]);
        
//         for(int i=0;i<n;i++){
//             pq.offer(new int[]{i,0,matrix[i][0]});
//         }

//         while(k-- > 1){
//             int curr[]= pq.poll();
//             int r=curr[0];
//             int c= curr[1];
//             if(c+1<n){
//                 pq.offer(new int[]{r,c+1,matrix[r][c+1]});
//             }
//         }
//         return pq.peek()[2];
//     }
// }

//general solution.
// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         PriorityQueue<Integer> pq=  new PriorityQueue<>((a,b)-> b-a);
//         int n= matrix.length;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(pq.size()<k) pq.offer(matrix[i][j]); 
//                 else if(pq.size()==k && pq.peek() > matrix[i][j]){
//                     pq.poll();
//                     pq.offer(matrix[i][j]); 
//                 }
                               
//             }
//         }
//         return pq.peek();
//     }
// }