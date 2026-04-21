//dutch national flag algorithm.
class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int zeros=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                swap(nums,zeros++,i);
            }else if(nums[i]==2){
                swap(nums,--n,i--);
            }
        }
    }
    private void swap(int nums[],int a,int b){
        int temp= nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}

//beautified
/*
class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int zeros=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                swap(nums,zeros++,i);
            }else if(nums[i]==2){
                swap(nums,--n,i);
            }
        }
    }
    private void swap(int nums[],int a,int b){
        int temp= nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
*/