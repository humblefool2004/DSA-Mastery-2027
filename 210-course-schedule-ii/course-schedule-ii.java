//when node is visited, push it, if node is visiting and you find it again, there's a cycle, if not visited, set visiting and dfs its neighbour.
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Deque<Integer> st= new ArrayDeque<>();

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

    private boolean dfs(int node,int[] state,List<List<Integer>> list, Deque<Integer> st){
        if(state[node]==1) return false; //cycle check
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