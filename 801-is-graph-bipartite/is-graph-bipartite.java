class Solution {
    private int[] arr;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        arr = new int[n];
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
                ans = (ans && bipartite(graph, -1, i));
            }

            if (!ans)
                return false;
        }
        return true;
    }

    private boolean bipartite(int[][] graph, int lastColour, int i) {
        for (int num : graph[i]) {
            if (arr[num] == 0) {
                int newColour = lastColour == -1 ? 1 : -1;
                arr[num] = newColour;
                if(!bipartite(graph, newColour, num)) return false;
            } else {
                if (arr[num] == lastColour)
                    return false;
            }

        }
        return true;
    }
}