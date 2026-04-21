class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int zeros=0;
        int ones=0;
        int twos=0;
        for(int i=0;i<n;i++){
            switch(nums[i]){
                case 0 : zeros++;
                break;
                case 1 : ones++;
                break;
                case 2 : twos++;
                break;
            }
        }
        int i=0;
        while(zeros-- >0){
            nums[i++]=0;
        }
        while(ones-->0){
            nums[i++]=1;
        }
        while(twos-->0){
            nums[i++]=2;
        }
    }
}