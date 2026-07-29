class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        if (totalSum % 2 == 1)
            return false;
        int target = totalSum / 2;

        boolean dp[][] = new boolean[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++)
            dp[i][0] = true;
        if (nums[0] <= target)
            dp[0][nums[0]] = true;
        for (int idx = 1; idx < nums.length; idx++) {
            for (int sum = 1; sum < dp[0].length; sum++) {
                dp[idx][sum] = dp[idx - 1][sum];

                if (sum >= nums[idx]) {
                    dp[idx][sum] |= dp[idx - 1][sum - nums[idx]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}

//recursion+memorization
/*
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        if (totalSum % 2 == 1)
            return false;
        int target = totalSum / 2;

        Boolean dp[][] = new Boolean[nums.length][target + 1]; //dp creatinon

        return check(nums, nums.length - 1, 0, target, dp);
    }

    private boolean check(int[] nums, int idx, int sum, int target, Boolean dp[][]) {

        if (sum == target)
            return true;
        if (idx < 0 || sum > target)
            return false;
        if (dp[idx][sum] != null)
            return dp[idx][sum];

        return dp[idx][sum] = (check(nums, idx - 1, sum + nums[idx], target, dp)
                || check(nums, idx - 1, sum, target, dp));
    }
}
*/