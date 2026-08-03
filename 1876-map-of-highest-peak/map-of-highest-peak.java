class Solution {

    public int[][] highestPeak(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) { // water
                    mat[i][j] = 0;
                    queue.offer(new int[] { i, j });
                } else { // land
                    mat[i][j] = -1;
                }
            }
        }

        int[][] dir = {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        };

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        mat[nr][nc] == -1) {

                    mat[nr][nc] = mat[r][c] + 1;
                    queue.offer(new int[] { nr, nc });
                }
            }
        }

        return mat;
    }
}