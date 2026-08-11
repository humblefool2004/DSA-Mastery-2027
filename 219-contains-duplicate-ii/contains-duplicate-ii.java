//sliding window solution
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set= new HashSet<>();

        int j=0;

        for(int i=0;i<nums.length;i++){
            if(i-j>k){
                set.remove(nums[j++]);
            }
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}

//HashMap Solution
// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         Map<Integer,Integer> map= new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             if(map.containsKey(nums[i])){
//                 if(i-map.get(nums[i]) <=k) return true;
//             }
//             map.put(nums[i],i);
//         }
//         return false;
//     }
// }