class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        permutations(ans,nums,0);
        return ans;
    }

    private void swap(int nums[],int a, int b){
        int temp= nums[a];
        nums[a]= nums[b];
        nums[b]= temp;
    }

    private void permutations(List<List<Integer>> ans, int nums[],int start){
        if(start==nums.length){
            List<Integer> list= new ArrayList<>();
            for(int num : nums) list.add(num);
            ans.add(list);
            return;
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            permutations(ans,nums,start+1);
            swap(nums,start,i);
        }
    }
}

//takes extra space
// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans= new ArrayList<>();
//         permutations(ans,nums,new ArrayList<>(),new boolean[nums.length]);
//         return ans;
//     }

//     private void permutations(List<List<Integer>> ans, int[] nums, List<Integer> list,boolean freq[]){
//         if(list.size()==nums.length){
//             ans.add(new ArrayList<>(list));
//             return;
//         } 
//         for(int i=0;i<nums.length;i++){
//             if(freq[i]==true) continue;

//             list.add(nums[i]);
//             freq[i]=true;
//             permutations(ans,nums,list,freq);
//             list.removeLast();
//             freq[i]=false;
//         }
//     }
// }