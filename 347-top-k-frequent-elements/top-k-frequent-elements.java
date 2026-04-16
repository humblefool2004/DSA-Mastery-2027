class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq= new PriorityQueue<>(
            (a,b)->
            a.getValue()-b.getValue()
        );
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans= new int[k];
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> entry= pq.poll();
            ans[i]=entry.getKey();
        }
        return ans;
    }
}