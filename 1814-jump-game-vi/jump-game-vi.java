class Solution {
    public int maxResult(int[] nums, int k) {
        int n= nums.length;
        Deque<Integer> dq= new ArrayDeque<>();
        int dp[] = new int[n];
        dq.offer(n-1);
        dp[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            while(!dq.isEmpty() && dq.peekFirst()>i+k){
                dq.pollFirst();
            }
            dp[i]=nums[i]+dp[dq.peek()];
            
            while(!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return dp[0];
        
    }
}