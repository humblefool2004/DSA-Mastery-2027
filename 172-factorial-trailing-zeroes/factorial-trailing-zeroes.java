class Solution {
    public int trailingZeroes(int n) {
        int ans=0;
        int i=1;
        while(n>0){
            n=n/5;
            ans+=n;
        }
        return ans;
    }
}