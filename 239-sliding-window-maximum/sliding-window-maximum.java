class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        int arr[]= new int[n-k+1];
        Deque<Integer> mono= new ArrayDeque();
        int idx=0;
        int curr=0;
        while(curr<k){
            while(!mono.isEmpty() && nums[mono.peekLast()] <=nums[curr]){
                mono.pollLast();
            }
            mono.offer(curr++);
        }
        arr[idx++]= nums[mono.peek()];
        while(curr<n){
            while(!mono.isEmpty() && nums[mono.peekLast()] <=nums[curr]){
                mono.pollLast();
            }
            while(!mono.isEmpty() && mono.peek() <idx){
                mono.poll();
            }
            mono.offer(curr++);
            arr[idx++]=nums[mono.peek()];
        }
        return arr;
    }
}