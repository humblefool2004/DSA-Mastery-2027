class Solution {
    private class DisjointSet{
        private final int size[];
        private final int parent[];
        public DisjointSet(int n){
            size= new int[n+1];
            parent= new int[n+1];
            for(int i=1;i<=n;i++){
                size[i]= 1;
                parent[i]=i;
            }
        }

        public int findParent(int u){
            if(u==parent[u]) return u;
            return parent[u]= findParent(parent[u]);
        }

        public boolean union(int u,int v){
            int uP=findParent(u);
            int vP= findParent(v);
            if(uP==vP) return false;
            if(size[uP] <size[vP]) {
                parent[uP]=vP;
                size[vP]+=size[uP];
            }else{
                parent[vP]=uP;
                size[uP]+= size[vP];
            }
            return true;
        }
    }



    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        DisjointSet ds= new DisjointSet(n);

        for(int[] edge : edges){
            if(!ds.union(edge[0],edge[1])) 
                return new int[]{edge[0],edge[1]};
        }
        return new int[]{-1,-1};
    }
}