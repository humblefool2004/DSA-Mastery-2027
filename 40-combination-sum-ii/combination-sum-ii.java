//level order approach or multiway tree, impressive for loop approach
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans= new ArrayList<>();
        getCombinations(ans,candidates,0,target,new ArrayList<>());
        return ans;
    }

    private void getCombinations(List<List<Integer>> ans, int[] candidates,int start, int target,List<Integer> list){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i]>target) break;
            if(i>start && candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            getCombinations(ans,candidates,i+1,target-candidates[i],list);
            list.removeLast();
        }
    }
}

//state space approach (pick not pick)
// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         Arrays.sort(candidates);
//         List<List<Integer>> ans= new ArrayList<>();
//         getCombinations(ans,candidates,0,target,new ArrayList<>());
//         return ans;
//     }
//     private void getCombinations(List<List<Integer>> ans, int[] candidates,int i, int target,List<Integer> list){
//         if(target==0){
//             ans.add(new ArrayList<>(list));
//             return;
//         }
//         if(i==candidates.length || candidates[i]>target) return;

//         //pick;
//         list.add(candidates[i]);
//         getCombinations(ans,candidates,i+1,target-candidates[i],list);
//         list.removeLast();
//         //not pick;
//         while(i<candidates.length-1 && candidates[i+1]==candidates[i]) i++;
//         getCombinations(ans,candidates,i+1,target,list);
//     }
// }