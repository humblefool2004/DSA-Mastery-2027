class Solution {
    private int[] arr;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        arr = new int[n];
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
                if(!bipartite(graph,-1,i)) return false;
            }
        }
        return true;
    }

    private boolean bipartite(int[][] graph, int currColour, int i) {
        for (int num : graph[i]) {
            if (arr[num] == 0) {
                arr[num] = -currColour;
                if(!bipartite(graph, -currColour, num)) return false;
            } else {
                if (arr[num] == currColour)
                    return false;
            }

        }
        return true;
    }
}