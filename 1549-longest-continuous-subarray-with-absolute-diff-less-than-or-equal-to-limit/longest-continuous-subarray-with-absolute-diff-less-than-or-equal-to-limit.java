class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> decreasing= new ArrayDeque<>();
        Deque<Integer> increasing= new ArrayDeque<>();

        int left=0;
        int right=0;
        int length=0;
        while(right<nums.length){
            while(!decreasing.isEmpty() && nums[decreasing.peekLast()]<nums[right]){
                decreasing.pollLast();
            }   
            while(!increasing.isEmpty() && nums[increasing.peekLast()]>nums[right]){
                increasing.pollLast();
            }
            increasing.offerLast(right);
            decreasing.offerLast(right);
            while(nums[decreasing.peekFirst()]-nums[increasing.peekFirst()]>limit){
                
                if(decreasing.peekFirst()==left){
                    decreasing.pollFirst();
                }
                if(increasing.peekFirst()==left){
                    increasing.pollFirst();
                }
                left++;
            }
            
            right++;
            length=Math.max(length,right-left);
        }

        return length;
    }
}