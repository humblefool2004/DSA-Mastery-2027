class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int localmax=0;

        for(int i=0;i<nums.length;i++){
            if(localmax<=0){
                localmax=nums[i];
            }else{
                localmax+=nums[i];
            }
            max=Math.max(max,localmax);
        }
        return max;
    }
}