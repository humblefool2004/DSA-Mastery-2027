class Solution {

    private boolean[][] visited;

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        int k = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                if (k > 0)
                    mat[r][c] = k;

                // Up
                if (r > 0 && !visited[r - 1][c]) {
                    visited[r - 1][c] = true;
                    queue.offer(new int[] { r - 1, c });
                }

                // Down
                if (r < m - 1 && !visited[r + 1][c]) {
                    visited[r + 1][c] = true;
                    queue.offer(new int[] { r + 1, c });
                }

                // Left
                if (c > 0 && !visited[r][c - 1]) {
                    visited[r][c - 1] = true;
                    queue.offer(new int[] { r, c - 1 });
                }

                // Right
                if (c < n - 1 && !visited[r][c + 1]) {
                    visited[r][c + 1] = true;
                    queue.offer(new int[] { r, c + 1 });
                }
            }

            k++;
        }

        return mat;
    }
}