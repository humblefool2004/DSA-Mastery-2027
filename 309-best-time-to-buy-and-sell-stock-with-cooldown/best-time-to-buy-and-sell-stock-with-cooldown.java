class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[i] < prices[j])
                    table[i][j] = prices[j] - prices[i];
            }
        }

        int[] dp = new int[n];
        int[] prefixMax = new int[n];

        prefixMax[0] = 0;

        for (int i = 1; i < n; i++) {

            for (int k = 0; k < i; k++) {

                if (k < 2)
                    dp[i] = Math.max(dp[i], table[k][i]);
                else
                    dp[i] = Math.max(dp[i], prefixMax[k - 2] + table[k][i]);
            }

            prefixMax[i] = Math.max(prefixMax[i - 1], dp[i]);
        }
        return prefixMax[n-1];
    }
}