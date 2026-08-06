class Solution {

    public int countSquares(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo= new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += solve(matrix, i, j,memo);
            }
        }

        return ans;
    }

    private int solve(int[][] matrix, int r, int c,int[][] memo) {

        if (r >= matrix.length || c >= matrix[0].length)
            return 0;

        if (matrix[r][c] == 0)
            return 0;
        if(memo[r][c]!=0) return memo[r][c];

        int right = solve(matrix, r, c + 1,memo);
        int down = solve(matrix, r + 1, c,memo);
        int diagonal = solve(matrix, r + 1, c + 1,memo);

        return memo[r][c]= 1 + Math.min(right, Math.min(down, diagonal));
    }
}