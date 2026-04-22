//optimal //note- we are pushing only row wise, therefore there are no visited.
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0]-b[0]
        );
        int temp = Math.min(k, nums1.length);
        for (int i = 0; i < temp; i++) {
            int sum= nums1[i]+nums2[0];
            pq.add(new int[] {sum, i, 0 });
        }
        while (count < k && !pq.isEmpty()) {
            int[] polled = pq.poll();
            int i = polled[1], j = polled[2];
            ans.add(List.of(nums1[i], nums2[j]));
            count++;
            if (j + 1 < nums2.length) {
                int sum=nums1[i] + nums2[j+1];
                pq.add(new int[] { sum,i, j + 1 });
            }
        }
        return ans;
    }
}

//brute force
// class Solution {
//     public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//         PriorityQueue<List<Integer>> pq= new PriorityQueue<>(
//             (a,b)-> Integer.compare((b.get(0)+b.get(1)),(a.get(0)+a.get(1)))
//         );
//         for(int i=0;i<nums1.length;i++){
//             for(int j=0;j<nums2.length;j++){

//                 int sum=nums1[i]+nums2[j];
//                 if(pq.size() == k && sum >pq.peek().get(0) + pq.peek().get(1)) break;
//                 List<Integer> list= new ArrayList<>();
//                 list.add(nums1[i]);
//                 list.add(nums2[j]);
//                 pq.add(list);
//                 if(pq.size()>k) pq.poll();
//             }
//         }
//         List<List<Integer>> ans=new ArrayList<>();
//         while(!pq.isEmpty()){
//             ans.add(new ArrayList<>(pq.poll()));
//         }
//         Collections.reverse(ans);
//         return ans;
//     }
// }