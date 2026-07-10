class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int dp[][]=new int[text1.length()+1][text2.length()+1];

        //initialisation of dp
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }

        char[] t1= text1.toCharArray();
        char[] t2= text2.toCharArray();

        for(int i=1;i<dp.length;i++){
            char r=t1[i-1];
            for(int j=1;j<dp[0].length;j++){
                if(r==t2[j-1]) dp[i][j]= dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[text1.length()][text2.length()];       
    }
}