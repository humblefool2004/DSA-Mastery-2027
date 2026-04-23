//trying out divide and conquer..hmm intresting.
class Solution {
    public int maxSubArray(int[] nums) {
        return solve(nums,0,nums.length-1);
    }
    private int solve(int nums[],int left,int right){
        if(left==right) return nums[left];
        int mid=left + (right-left)/2;
        int leftMax= solve(nums,left,mid);
        int rightMax=solve(nums,mid+1,right);
        int crossMax= cross(nums,left,mid,right);
        return Math.max(Math.max(leftMax,rightMax),crossMax);
    }
    //core of this algorithm
    private int cross(int nums[],int left,int mid,int right){
        int sum=0;
        int leftMax=Integer.MIN_VALUE;
        for(int i=mid;i>=left;i--){
            sum+=nums[i];
            leftMax=Math.max(sum,leftMax);
        }
        sum=0;
        int rightMax=Integer.MIN_VALUE;
        for(int i=mid+1;i<=right;i++){
            sum+=nums[i];
            rightMax=Math.max(sum,rightMax);
        }
        return leftMax+rightMax;
    }
}

//best solution
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int max=Integer.MIN_VALUE;
//         int localmax=0;

//         for(int i=0;i<nums.length;i++){
//             if(localmax<=0){
//                 localmax=nums[i];
//             }else{
//                 localmax+=nums[i];
//             }
//             max=Math.max(max,localmax);
//         }
//         return max;
//     }
// }