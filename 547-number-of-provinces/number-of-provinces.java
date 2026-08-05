class Solution {
    private class DisjointSet{
        private int[] size;
        private int[] ultP;

        public DisjointSet(int n){
            size=new int[n+1];
            ultP= new int[n+1];
            for(int i=1;i<=n;i++){
                size[i]=1;
                ultP[i]=i;
            }
        }
        public int findParent(int u){
            if(u==ultP[u]) return u;
            return ultP[u]= findParent(ultP[u]);
        }
        public void union(int u,int v){
            int uP=findParent(u);
            int vP= findParent(v);
            if(uP==vP) return;
            if(size[uP]<size[vP]){
                ultP[uP]=vP;
                size[vP]+=size[uP];
            }else{
                ultP[vP]=uP;
                size[uP]+=size[vP];
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        DisjointSet ds= new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1) ds.union(i+1,j+1);
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(ds.findParent(i)==i) ans++;
        }
        return ans;
    }
}