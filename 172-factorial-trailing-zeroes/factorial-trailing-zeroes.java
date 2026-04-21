class Solution {
    public int trailingZeroes(int n) {
        int ans=0;
        int i=1;
        while(n>=Math.pow(5,i)){
            ans+=n/Math.pow(5,i);
            i++;
        }
        return ans;
    }
}