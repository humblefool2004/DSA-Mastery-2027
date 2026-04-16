//bucketSort approach
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        //uses index as frequency // array of lists
        List<Integer>[] bucket= new List[n+1];

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int freq=entry.getValue();
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        }
        int ans[]= new int[k];
        int count=0;
        for(int i=n;i>0 && count<k;i--){
            if(bucket[i]!=null){
                for(int num : bucket[i]){
                    if (count < k) {
                        ans[count++] = num;
                    } else {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}

/*
//Priority Queue Approach
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
*/