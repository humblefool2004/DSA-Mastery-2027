class Solution {
    public int majorityElement(int[] nums) {
        int majority=nums[0];
        int track=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=majority){
                track--;
            }else track++;
            if(track==0){
                majority=nums[i];
                track=1;
            }
        }
        return majority;
    }
}