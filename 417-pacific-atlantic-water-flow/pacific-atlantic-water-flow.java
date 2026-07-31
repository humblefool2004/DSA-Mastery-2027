class Solution {
    private boolean[][][] visited;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n= heights[0].length;
        visited= new boolean[m][n][2];
        for(int i=0;i<m;i++){
            if(!visited[i][0][0]){
                dfs(i,0,heights,0,-1);
            }   
        }
        for(int j=0;j<n;j++){
            if(!visited[0][j][0]){
                dfs(0,j,heights,0,-1);
            }
        }

        for(int i=0;i<m;i++){
            if(visited[i][n-1][1]==false){
                dfs(i,n-1,heights,1,-1);
            }   
        }
        for(int j=0;j<n;j++){
            if(visited[m-1][j][1]==false){
                dfs(m-1,j,heights,1,-1);
            }
        }


        List<List<Integer>> list= new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j][0] && visited[i][j][1]){
                    List<Integer> list1=List.of(i,j);
                    list.add(list1);
                }
            }
        }
        return list;
    }

    private void dfs(int i,int j,int[][] heights,int check,int prev){
        if(i>=heights.length || i<0 || j>=heights[0].length || j<0) return;
        if(visited[i][j][check]){
            return;
        }
        if (heights[i][j] < prev)
            return;
        visited[i][j][check]=true;
        prev=heights[i][j];
        dfs(i-1,j,heights,check,prev);
        dfs(i+1,j,heights,check,prev);
        dfs(i,j-1,heights,check,prev);
        dfs(i,j+1,heights,check,prev);
        
    }
}