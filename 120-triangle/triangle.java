class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        int[] dp = new int[n];
        
        dp[0] = triangle.get(0).get(0);

        for(int i=1;i<n;i++){
            dp[i]= dp[i-1] + triangle.get(i).get(i);

            for(int j=i-1;j>0;j--){
                dp[j]= triangle.get(i).get(j)+ Math.min(dp[j],dp[j-1]);                
            }

            dp[0] += triangle.get(i).get(0);
        }

        int min= Integer.MAX_VALUE;
        for(int x : dp){
            min=Math.min(x,min);
        }
        return min;
    }
}