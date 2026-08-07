class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        int ans[]= new int[n-k+1];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> nums[b]-nums[a]);
        for(int i=0;i<k;i++){
            pq.add(i);
        }
        ans[0]=nums[pq.peek()];
        int end=k; //curr position of end
        for(int i=1;i<=n-k;i++){
            //logic to remove the last element
            while(!pq.isEmpty() && pq.peek()<i) pq.poll();
            pq.add(end++);
            ans[i]=nums[pq.peek()];
        }
        return ans;

    }
}