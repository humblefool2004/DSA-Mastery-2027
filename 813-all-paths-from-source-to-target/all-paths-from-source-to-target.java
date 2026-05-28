class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans= new ArrayList<>();

        dfs(ans,graph, new ArrayList<>(),0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans,int[][] graph, List<Integer> list,int i){
        
        list.add(i);
        if(i==graph.length-1){
            ans.add(new ArrayList<>(list));
        }else{
            int[] nodes= graph[i];
        
            for(int node : nodes){
                dfs(ans,graph,list,node);
            }
        }
        
        list.removeLast();       
    }
}