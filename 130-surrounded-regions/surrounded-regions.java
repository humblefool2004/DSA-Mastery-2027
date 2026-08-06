//multisource bfs
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[] { i, 0 });
                board[i][0] = '#';
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new int[] { i, n - 1 });
                board[i][n - 1] = '#';
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new int[] { 0, j });
                board[0][j] = '#';
            }
            if (board[m - 1][j] == 'O') {
                queue.offer(new int[] { m - 1, j });
                board[m - 1][j] = '#';
            }
        }
        int[][] dir = {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        };

        while (!queue.isEmpty()) {
            int[] a= queue.poll();
            int r= a[0];
            int c= a[1];
            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        board[nr][nc] == 'O') {

                    board[nr][nc] = '#';
                    queue.offer(new int[] { nr, nc });
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
}