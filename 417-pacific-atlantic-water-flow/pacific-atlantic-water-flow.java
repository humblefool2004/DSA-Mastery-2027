class Solution {

    private boolean[][] pacific;
    private boolean[][] atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacific);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, heights, pacific);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, heights, atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, heights, atlantic);
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    list.add(List.of(i, j));
                }
            }
        }

        return list;
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] visited) {

        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length)
            return;

        if (visited[i][j])
            return;

        visited[i][j] = true;

        if (i > 0 && heights[i - 1][j] >= heights[i][j])
            dfs(i - 1, j, heights, visited);

        if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j])
            dfs(i + 1, j, heights, visited);

        if (j > 0 && heights[i][j - 1] >= heights[i][j])
            dfs(i, j - 1, heights, visited);

        if (j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j])
            dfs(i, j + 1, heights, visited);
    }
}