class Solution {

    public int minCut(String s) {
        int n= s.length();
        int[] minCut=new int[n];
        Arrays.fill(minCut,Integer.MAX_VALUE);
        boolean[][] dp= new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                dp[i][j]= checkPalindrome(s,i,j);
            }
        }
        minCut[0]=0;
        for(int i=1;i<n;i++){
            if(dp[0][i]) minCut[i]=0;
            else{
                for(int k=0;k<i;k++){
                    if(dp[k+1][i])
                        minCut[i]= Math.min(minCut[i],minCut[k]+1);
                }                
            }
        }
        
        return minCut[n-1];
    }

    private boolean checkPalindrome(String s, int start,int end){
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}