class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(k%n==0 || k==0) return;
        int first= n-(k%n);
        int i=first;
        int[] copy=new int[n];
        int j=0;
        while(i<n){
            copy[j++]=nums[i++];
        }
      
        i=0;
        while(i<first){
            copy[j++]=nums[i++];
        }
        
        for(i=0;i<n;i++){
            nums[i]=copy[i];
        }
    }
}