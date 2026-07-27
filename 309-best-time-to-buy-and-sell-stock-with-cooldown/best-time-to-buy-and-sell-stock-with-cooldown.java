//O(n) solution
class Solution {
    public int maxProfit(int[] prices) {
        int hold= -prices[0]; //max with holding a stock;
        int sold= 0; //max with sold today;
        int rest= 0; // max with not holding and not sold;

        for(int i=1;i<prices.length;i++){
            int prevHold=hold;
            int prevSold= sold;
            int prevRest= rest;

            hold= Math.max(prevHold, prevRest - prices[i]);
            sold= prevHold + prices[i];
            rest= Math.max(prevRest,prevSold);
        }
        return Math.max(sold,rest);
    }
}


//brute force
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         if (n == 1)
//             return 0;
//         int[][] table = new int[n][n];
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (prices[i] < prices[j])
//                     table[i][j] = prices[j] - prices[i];
//             }
//         }

//         int[] dp = new int[n];
//         int[] prefixMax = new int[n];

//         prefixMax[0] = 0;

//         for (int i = 1; i < n; i++) {

//             for (int k = 0; k < i; k++) {

//                 if (k < 2)
//                     dp[i] = Math.max(dp[i], table[k][i]);
//                 else
//                     dp[i] = Math.max(dp[i], prefixMax[k - 2] + table[k][i]);
//             }

//             prefixMax[i] = Math.max(prefixMax[i - 1], dp[i]);
//         }
//         return prefixMax[n-1];
//     }
// }