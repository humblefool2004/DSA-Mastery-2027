class Solution {

    private int[][][] memo;

    public int countDigitOne(int n) {
        memo=new int[11][2][11];
        for(int i=0;i<11;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        String st= String.valueOf(n);
        return solve(st,0,1,0);
    }

    private int solve(String st,int idx,int bool,int countOfOne){
        if(idx==st.length()) return countOfOne;
        if(memo[idx][bool][countOfOne] !=-1) return memo[idx][bool][countOfOne];
        int ub= (bool==1) ? st.charAt(idx)-'0' : 9;
        int res=0;
        for(int i=0;i<=ub;i++){
            res+=solve(st,idx+1,(bool==1 && i==ub)? 1: 0 ,(i==1)? countOfOne+1 : countOfOne);
        }
        return memo[idx][bool][countOfOne]=res;
    }
}