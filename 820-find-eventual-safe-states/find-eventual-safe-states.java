class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] state=new int[graph.length];
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(isTerminal(i,state,graph)){
                ans.add(i);
            }
        }    
        return ans;
    }

    private boolean isTerminal(int node, int[] state,int graph[][]){
        if(state[node]==1) return false;
        if(state[node]==2) return true;

        state[node]=1;
        for(int i=0;i<graph[node].length;i++){
            if(!isTerminal(graph[node][i],state,graph)){
                return false;
            }
        }
        state[node]=2;
        return true;
    }
}

