//binary search, search values instead of index
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n=matrix.length;
        int low= matrix[0][0];
        int high=matrix[n-1][n-1];
        
        while(low<high){
            int mid=low+ (high-low)/2;
            if(count(matrix,mid)<k){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }

    private int count(int[][] nums, int target){
        int count=0;
        int n= nums.length;
        int row=n-1;
        int col=0;
        while(row>=0 && col<n){
            if(target<nums[row][col]){
                row--;
            }else{
                count+= row+1;
                col++;
            }
        }
        return count;
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