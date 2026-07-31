class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //sliding window protocol
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int currSumForMax=0;
        int currSumForMin=0;
        int totalSum=0;
        for(int idx=0;idx<nums.length;idx++){
            if(currSumForMax<0){
                currSumForMax=nums[idx];
            }else{
                currSumForMax+=nums[idx];
            }
            max= Math.max(max,currSumForMax);
            if(currSumForMin>0){
                currSumForMin=nums[idx];
            }else{
                currSumForMin+=nums[idx];
            }
            min=Math.min(min,currSumForMin);
            totalSum+=nums[idx];
        }
        if(max<0) return max;
        
        return Math.max(max,totalSum-min);
    }
}