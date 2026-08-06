class Solution {

    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int ans = 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (matrix[i][j] == 0)
                    dp[i][j] = 0;
                else if (i == m - 1 || j == n - 1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = 1 + Math.min(dp[i][j + 1],
                            Math.min(dp[i + 1][j],
                                    dp[i + 1][j + 1]));

                ans += dp[i][j];
            }
        }

        return ans;
    }
}