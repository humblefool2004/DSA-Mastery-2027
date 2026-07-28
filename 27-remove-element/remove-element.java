class Solution {
    public int removeElement(int[] nums, int val) {
        int real=0;
        int countReal=0;
        for(int num : nums){
            if(num!=val){
                nums[real++]=num;
                countReal++;
            }
        }
        return countReal;
    }
}