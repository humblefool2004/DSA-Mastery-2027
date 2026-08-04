class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n==1) return 10;
        int choices=8;
        int curr=81;
        int total=91;
        for(int len=3 ;len<=n;len++){
            curr*=choices--;
            total+=curr;
        }
        return total;
    }
}