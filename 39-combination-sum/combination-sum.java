//pruning approach
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(candidates);
        getCombinations(ans,candidates,0,target,new ArrayList<>());
        return ans;
    }

    private void getCombinations(List<List<Integer>> ans,int[] candidates, int i, int target, List<Integer> arr){
        if(target==0){
            ans.add(new ArrayList<>(arr));
            return;
        } 
        if(i==candidates.length || candidates[i]>target) {
            return;
        }
        //pick
            arr.add(candidates[i]);
            getCombinations(ans,candidates,i,target-candidates[i],arr);
            arr.removeLast();

        //not pick;
        getCombinations(ans,candidates,i+1,target,arr);

    }
}
// search all
// class Solution {
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> ans= new ArrayList<>();
//         getCombinations(ans,candidates,0,target,new ArrayList<>());
//         return ans;
//     }

//     private void getCombinations(List<List<Integer>> ans,int[] candidates, int i, int target, List<Integer> arr){
//         if(i==candidates.length) {
//             if(target==0) ans.add(new ArrayList<>(arr));
//             return;
//         }
//         //pick
//         if(candidates[i]<=target){
//             arr.add(candidates[i]);
//             getCombinations(ans,candidates,i,target-candidates[i],arr);
//             arr.removeLast();
//         }

//         //not pick;
//         getCombinations(ans,candidates,i+1,target,arr);

//     }
// }