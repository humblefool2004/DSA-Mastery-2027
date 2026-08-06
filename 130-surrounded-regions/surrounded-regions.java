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
                board[0][j] ='#';
            }
            if (board[m - 1][j] == 'O') {
                queue.offer(new int[] { m - 1, j });
                board[m - 1][j] = '#';
            }
        }

        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            int r=a[0];
            int c= a[1];
            if (r != 0 && board[r - 1][c] == 'O') {
                queue.offer(new int[] { r - 1, c });
                board[r - 1][c] ='#';
            }
            if (r != m - 1 && board[r + 1][c] == 'O') {
                queue.offer(new int[] { r + 1, c });
                board[r + 1][c] = '#';
            }

            if (c != 0 && board[r][c - 1] == 'O') {
                queue.offer(new int[] { r, c - 1 });
                board[r][c - 1] = '#';
            }

            if (c != n - 1 && board[r][c + 1] == 'O') {
                queue.offer(new int[] { r, c + 1 });
                board[r][c + 1] = '#';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') 
                    board[i][j] = 'X';
                else if(board[i][j]=='#')
                    board[i][j]='O';
            }
        }
    }
}