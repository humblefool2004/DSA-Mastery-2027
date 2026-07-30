//subset sum S1-S2=D approach
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        if (Math.abs(target) > totalSum)
            return 0;

        if ((target + totalSum) % 2 != 0)
            return 0;

        int required = (target + totalSum) / 2;

        int dp[] = new int[required + 1];

        dp[0] = 1;
        if (nums[0] <= required)
            dp[nums[0]] += 1;

        for (int idx = 1; idx < nums.length; idx++) {
            for (int sum = required; sum >= nums[idx]; sum--) {
                dp[sum] += dp[sum - nums[idx]];
            }
        }
        return dp[required];
    }
}

//Recursion + Memorization
// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {

//         Integer[][] dp= new Integer[nums.length][2001];

//         return search(nums.length-1,nums,target,0,dp);
//     }
//     //search returns the number of paths.
//     private int search(int idx,int[] nums, int target,int sum,Integer[][] dp){
//         if(idx<0){
//             if(sum==target) return 1;
//             return 0;
//         }
//         if(dp[idx][sum+1000]!=null) return dp[idx][sum+1000];

//         int plus=search(idx-1,nums,target,sum+nums[idx],dp);
//         int minus=search(idx-1,nums,target,sum-nums[idx],dp);
//         return dp[idx][sum+1000]=plus+minus;
//     }
// }