class Solution {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // Left & Right boundaries
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0, board);

            if (board[i][n - 1] == 'O')
                dfs(i, n - 1, board);
        }

        // Top & Bottom boundaries
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(0, j, board);

            if (board[m - 1][j] == 'O')
                dfs(m - 1, j, board);
        }

        // Flip surrounded regions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {

        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length ||
            board[r][c] != 'O')
            return;

        board[r][c] = '#';

        dfs(r - 1, c, board);
        dfs(r + 1, c, board);
        dfs(r, c - 1, board);
        dfs(r, c + 1, board);
    }
}