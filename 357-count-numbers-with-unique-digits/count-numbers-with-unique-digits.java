class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n==1) return 10;
        if(n==2) return 9*9+10;
        int ans=81;
        int i=3;
        int finalAns=91;
        while(i<=n){
            ans*=(10-(i++)+1);
            finalAns+=ans;
        }
        return finalAns;
    }
}