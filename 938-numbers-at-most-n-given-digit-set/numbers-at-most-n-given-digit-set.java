class Solution {

    private int memo[][][];

    public int atMostNGivenDigitSet(String[] digits, int n) {
        String st= String.valueOf(n);
        memo= new int[st.length()][2][2];
        for(int i=0;i<st.length();i++){
            for(int j=0;j<2;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        return solve(st,digits,0,1,0);
    }

    private int solve(String st, String[] digits,int idx,int tight,int started){
        if(idx==st.length()){
            if(started==1) return 1;
            return 0;
        }

        if(memo[idx][tight][started]!=-1) return memo[idx][tight][started];
        int res=0;
        if(started==0) res+=solve(st,digits,idx+1,0,0);

        for(String digit : digits){
            if(tight==1 && digit.charAt(0)> st.charAt(idx)) break;
            int newTight= (tight==1 && st.charAt(idx)==digit.charAt(0)) ? 1 : 0;
            res+= solve(st,digits,idx+1,newTight,1 );
        } 
        return memo[idx][tight][started]=res;
    }
}