class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> map= new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        Map<Integer,Integer> need= new HashMap<>();

        for(int num : nums){
            if(map.get(num)==0){
                continue;
            }
            map.put(num, map.get(num)-1);
            if(need.getOrDefault(num,0)>0){
                need.put(num+1, need.getOrDefault(num+1,0)+1);
                need.put(num, need.get(num)-1);
            }else if(map.getOrDefault(num+1,0)>0 && map.getOrDefault(num+2,0)>0){
                map.put(num+1,map.get(num+1)-1);
                map.put(num+2,map.get(num+2)-1);
                need.put(num+3,need.getOrDefault(num+3,0)+1);
            }else return false;
        }

        return true;
    }
}