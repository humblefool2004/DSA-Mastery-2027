class Solution {
    public double myPow(double x, int n) {
        long N=n;
        if(N==0) return 1;
        if(N==1) return x;
        if(N<0){
            N=-N;
            x=1/x;
        }
        double half= myPow(x,(int)(N/2));
        if(N%2==0)
        return half*half;
        else{
            return x*half*half;
        }
    }
}