class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int i=n-1;
        int count=0;
        while(i>0){
            int rem=0;
            for(int j=i;j>=0;j--){
                if(j+nums[j]>=i) rem=j;
            }
            i=rem;
            count++;
        }
        return count;
    }
}