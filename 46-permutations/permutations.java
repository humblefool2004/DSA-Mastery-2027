class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        permutations(ans,nums,new ArrayList<>(),new HashSet<>());
        return ans;
    }

    private void permutations(List<List<Integer>> ans, int[] nums, List<Integer> list,Set<Integer> set){
        if(set.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        } 
        for(int i=0;i<nums.length;i++){
            if(set.contains(i)) continue;
            list.add(nums[i]);
            set.add(i);
            permutations(ans,nums,list,set);
            list.removeLast();
            set.remove(i);
        }
    }
}