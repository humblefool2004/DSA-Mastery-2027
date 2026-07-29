class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;
        if (totalSum % 2 == 1)
            return false;
        int target = totalSum / 2;

        Boolean dp[][] = new Boolean[nums.length][target + 1];

        return check(nums, nums.length - 1, 0, totalSum / 2, dp);
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