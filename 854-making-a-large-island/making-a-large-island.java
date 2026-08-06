class Solution {
    private class DisjointSet{
        private int size[];
        private int parent[];

        public DisjointSet(int n){
            size= new int[n];
            parent= new int[n];
            for(int i=0;i<n;i++){
                size[i]=1;
                parent[i]=i;
            }
        }

        public int findParent(int u){
            if(u==parent[u]) return u;
            return parent[u]= findParent(parent[u]);
        }

        public void union(int u, int v){
            int up = findParent(u);
            int vp = findParent(v);
            if(up==vp) return;
            if(size[up]<size[vp]){
                size[vp]+=size[up];
                parent[up]= vp;
            }else{
                size[up]+=size[vp];
                parent[vp]=up;
            }
        }

    }
    public int largestIsland(int[][] grid) {
        int n= grid.length;
        DisjointSet ds= new DisjointSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(i!=0 && grid[i-1][j]==1){
                        ds.union((i-1)*n+j,i*n+j);
                    }
                    if(j!=0 && grid[i][j-1]==1){
                        ds.union(i*n+j, i*n + j-1);
                    }
                }
            }
        }
        int maxIslandSize=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    HashSet<Integer> set= new HashSet<>(4);
                    int curr=1;
                    if(i!=0 && grid[i-1][j]==1) 
                        set.add(ds.findParent(  (i-1)*n+j  ));
                    if(j!=0 && grid[i][j-1]==1) 
                        set.add(ds.findParent(  (i)*n+j-1  ));
                    if(i!=n-1 && grid[i+1][j]==1) 
                        set.add(ds.findParent(  (i+1)*n+j  ));
                    if(j!=n-1 && grid[i][j+1]==1) 
                        set.add(ds.findParent(  (i)*n+j+1 ));
                    for(int u : set){
                        curr+=ds.size[u];
                    }
                    maxIslandSize= Math.max(curr,maxIslandSize);
                }
            }
        }
        if (maxIslandSize == 0)
            return n * n;
        return maxIslandSize;
    }
}

// dfs Solution
// class Solution {
//     public int largestIsland(int[][] grid) {
//         int n=grid.length;
//         int id=2;
//         Map<Integer,Integer> map= new HashMap<>();
//         map.put(0,0);
//         boolean hasZero=false;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]==0) hasZero=true;
//                 if(grid[i][j]==1){
//                     int count=dfs(grid,id,i,j);
//                     map.put(id,count);
//                     id++;
//                 }
//             }
//         }
//         if(!hasZero) return n*n;

//         int maxIsland=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]==0){
//                     int curr=1;
//                     Set<Integer> set= new HashSet<>();
//                     if(i!=0) set.add(grid[i-1][j]);
//                     if(j!=0) set.add(grid[i][j-1]);
//                     if(i!=n-1) set.add(grid[i+1][j]);
//                     if(j!=n-1) set.add(grid[i][j+1]);
//                     for(int num : set){
//                         curr+= map.get(num);
//                     }
//                     maxIsland=Math.max(curr,maxIsland);
//                 }
//             }
//         }
//         return maxIsland;

//     }

//     private int dfs(int[][] grid, int id, int r, int c){
//         if(r<0 || r>=grid.length || c<0 || c>=grid.length || grid[r][c] != 1) return 0;
//         grid[r][c]=id;
//         return 1+dfs(grid,id,r-1,c)+dfs(grid,id,r+1,c)+dfs(grid,id,r,c-1)+dfs(grid,id,r,c+1);
//     }
// }