class Solution {
    public int numDecodings(String s) {
        int dp[][]= new int[3][s.length()];
        dpInitializer(dp,s);
        for(int i=2;i<dp[0].length;i++){
            if(valid(s.charAt(i))){
                dp[0][i]= dp[2][i-1];
            }
            if(valid(s.charAt(i-1),s.charAt(i))){
                dp[1][i]= dp[2][i-2];
            }
            dp[2][i]= dp[0][i]+dp[1][i];
        }
        return dp[2][s.length()-1];
    }

    private boolean valid(char ch ){
        if(ch!='0') return true;
        return false;
    }

    private boolean valid(char ch1, char ch2){
        if(ch1=='1'|| (ch1=='2' && ch2>='0' && ch2<='6')) 
            return true;
        return false;
    }

    private void dpInitializer(int dp[][], String s){
        dp[0][0]= valid(s.charAt(0)) ? 1 : 0;
        dp[2][0]= dp[0][0]+dp[1][0];
        if(s.length()>=2){
            if(valid(s.charAt(1)))
                dp[0][1] = dp[2][0];
            dp[1][1] = valid(s.charAt(0),s.charAt(1)) ? 1:0;
            dp[2][1] = dp[0][1]+dp[1][1];
        }
    }
}