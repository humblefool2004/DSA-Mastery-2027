class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        getSubsets(ans,nums,0,new ArrayList<>());
        return ans;
    }

    private void getSubsets(List<List<Integer>> ans, int[] nums, int i,List<Integer> list){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        //pick
        list.add(nums[i]);
        getSubsets(ans,nums,i+1,list);
        list.removeLast();
        //not pick
        getSubsets(ans,nums,i+1,list);
    }
}