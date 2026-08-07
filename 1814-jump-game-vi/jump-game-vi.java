class Solution {
    public int maxResult(int[] nums, int k) {
        int n= nums.length;
        Deque<Integer> dq= new ArrayDeque<>();
        int dp[] = new int[n];
        dq.offer(0);
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            while(!dq.isEmpty() && dq.peekFirst()<i-k){
                dq.pollFirst();
            }
            dp[i]=nums[i]+dp[dq.peek()];
            
            while(!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return dp[n-1];
        
    }
}