class Solution {
    private boolean[][][] visited;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        visited = new boolean[m][n][2];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights, 0);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, heights, 0);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, heights, 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, heights, 1);
        }

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j][0] && visited[i][j][1]) {
                    list.add(List.of(i, j));
                }
            }
        }

        return list;
    }

    private void dfs(int i, int j, int[][] heights, int check) {

        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length)
            return;

        if (visited[i][j][check])
            return;

        visited[i][j][check] = true;

        if (i > 0 && heights[i - 1][j] >= heights[i][j])
            dfs(i - 1, j, heights, check);

        if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j])
            dfs(i + 1, j, heights, check);

        if (j > 0 && heights[i][j - 1] >= heights[i][j])
            dfs(i, j - 1, heights, check);

        if (j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j])
            dfs(i, j + 1, heights, check);
    }
}