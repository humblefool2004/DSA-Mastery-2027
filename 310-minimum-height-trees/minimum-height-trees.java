class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return List.of(0);
        List<List<Integer>> list= new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        int[] degree= new int[n];
        Deque<Integer> queue= new ArrayDeque<>();
        for(int i=0;i<n;i++){
            degree[i]=list.get(i).size();
            if(degree[i]==1) queue.add(i); 
        }

        int remaining=n;

        while(remaining>2){
            int size= queue.size();
            for(int i=0;i<size;i++){
                int removed=queue.poll();
                    for(int num : list.get(removed)){
                        if(--degree[num]==1) queue.add(num);
                    }
            }
            remaining-=size;
        }
        return new ArrayList<>(queue);
    }
}