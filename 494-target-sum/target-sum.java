class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return search(nums.length-1,nums,target,0);
    }

    //search returns the number of paths.
    private int search(int idx,int[] nums, int target,int sum){
        if(idx<0){
            if(sum==target) return 1;
            return 0;
        }

        int plus=search(idx-1,nums,target,sum+nums[idx]);
        int minus=search(idx-1,nums,target,sum-nums[idx]);
        return plus+minus;
    }
}