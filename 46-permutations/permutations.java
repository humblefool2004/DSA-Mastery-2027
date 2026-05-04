class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        permutations(ans,nums,new ArrayList<>(),new boolean[nums.length]);
        return ans;
    }

    private void permutations(List<List<Integer>> ans, int[] nums, List<Integer> list,boolean freq[]){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        } 
        for(int i=0;i<nums.length;i++){
            if(freq[i]==true) continue;

            list.add(nums[i]);
            freq[i]=true;
            permutations(ans,nums,list,freq);
            list.removeLast();
            freq[i]=false;
        }
    }
}