class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Stack<Integer> st= new Stack<>();

        int[] state = new int[numCourses]; //0 not visited, 1 visiting, 2 visited.

        for(int i=0;i<numCourses;i++){
            if(!dfs(i,state,list,st))
                return new int[0];
        }

        int ans[] = new int[numCourses];
        int i=0;
        while(!st.isEmpty()){
            ans[i++]= st.pop();
        }
        return ans;
    }

    private boolean dfs(int node,int[] state,List<List<Integer>> list, Stack<Integer> st){
        if(state[node]==1) return false;
        if(state[node]==2) return true;
        
        state[node]=1;
        for(int num : list.get(node)){
            if(!dfs(num,state,list,st))
                return false;
        }
        state[node]=2;
        st.push(node);

        return true;
    }

}