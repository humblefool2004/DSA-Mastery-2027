// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int dp[][] = new int[nums.length][2001];


//     }
// }

//Recursion + Memorization
class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        Integer[][] dp= new Integer[nums.length][2002];

        return search(nums.length-1,nums,target,0,dp);
    }
    //search returns the number of paths.
    private int search(int idx,int[] nums, int target,int sum,Integer[][] dp){
        if(idx<0){
            if(sum==target) return 1;
            return 0;
        }
        if(dp[idx][sum+1000]!=null) return dp[idx][sum+1000];

        int plus=search(idx-1,nums,target,sum+nums[idx],dp);
        int minus=search(idx-1,nums,target,sum-nums[idx],dp);
        return dp[idx][sum+1000]=plus+minus;
    }
}