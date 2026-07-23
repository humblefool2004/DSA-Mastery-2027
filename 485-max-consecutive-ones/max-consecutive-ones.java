class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currCount= 0;
        int max=0;
        for(int num : nums){
            if(num==0) currCount=0;
            else{
                if(++currCount>max) max=currCount;
            }
        }
        return max;
        
    }
}