class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int id=2;
        Map<Integer,Integer> map= new HashMap<>();
        map.put(0,0);
        boolean flagFor0=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) flagFor0=true;
                if(grid[i][j]==1){
                    int count=dfs(grid,id,i,j);
                    map.put(id,count);
                    id++;
                }
            }
        }
        if(!flagFor0) return n*n;

        int maxIsland=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    int curr=1;
                    Set<Integer> set= new HashSet<>();
                    if(i!=0) set.add(grid[i-1][j]);
                    if(j!=0) set.add(grid[i][j-1]);
                    if(i!=n-1) set.add(grid[i+1][j]);
                    if(j!=n-1) set.add(grid[i][j+1]);
                    for(int num : set){
                        curr+= map.get(num);
                    }
                    maxIsland=Math.max(curr,maxIsland);
                }
            }
        }
        return maxIsland;

    }

    private int dfs(int[][] grid, int id, int r, int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid.length || grid[r][c]==id || grid[r][c]==0) return 0;
        grid[r][c]=id;
        return 1+dfs(grid,id,r-1,c)+dfs(grid,id,r+1,c)+dfs(grid,id,r,c-1)+dfs(grid,id,r,c+1);
    }
}