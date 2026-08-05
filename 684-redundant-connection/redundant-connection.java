class Solution {
    private class DisjointSet{
        private int size[];
        private int ultP[];
        public DisjointSet(int n){
            size= new int[n+1];
            ultP= new int[n+1];
            for(int i=1;i<=n;i++){
                size[i]= 1;
                ultP[i]=i;
            }
        }

        public int findParent(int u){
            if(u==ultP[u]) return u;
            return ultP[u]= findParent(ultP[u]);
        }

        public boolean union(int u,int v){
            int uP=findParent(u);
            int vP= findParent(v);
            if(uP==vP) return false;
            if(size[uP] <size[vP]) {
                ultP[uP]=vP;
                size[vP]+=size[uP];
            }else{
                ultP[vP]=uP;
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