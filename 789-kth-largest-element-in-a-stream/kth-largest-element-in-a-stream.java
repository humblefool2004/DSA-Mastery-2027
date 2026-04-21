class KthLargest {

    PriorityQueue<Integer> pq;
    int kth=0;
    public KthLargest(int k, int[] nums) {
        pq= new PriorityQueue<>();
        kth=k;
        for(int num:nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if (pq.size() < kth) {
            pq.offer(val);
        } else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */