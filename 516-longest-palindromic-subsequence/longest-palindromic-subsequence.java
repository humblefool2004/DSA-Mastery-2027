//Interval dp approach
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        
        int dp[][]= new int[n][n];

        int len=1;
        while(len<=n){
            for(int i=0;i<n-len+1;i++){
                int j= i+len-1;
                if(i==j) dp[i][j]=1;
                else if(s.charAt(i)==s.charAt(j))
                    dp[i][j]= dp[i+1][j-1] +2;
                else
                    dp[i][j]= Math.max(dp[i+1][j],dp[i][j-1]);
            }

            len++;
        }
        return dp[0][n-1];

    }
}


// String Reversal + LCS approach
// class Solution {
//     public int longestPalindromeSubseq(String s) {
//         int n= s.length();
//         int dp[][] = new int[n+1][n+1];

//         String rev= new StringBuilder(s).reverse().toString();

//         for(int i=1;i<dp.length;i++){
//             char r= s.charAt(i-1);
//             for(int j=1;j<dp[0].length;j++){
//                 if(rev.charAt(j-1)==r){
//                     dp[i][j]=dp[i-1][j-1]+1;
//                 }
//                 else{
//                     dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
//                 }
//             }
//         }
//         return dp[n][n];
        

//     }
// }