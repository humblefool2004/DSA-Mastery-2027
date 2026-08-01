class Solution {
    public int[] countBits(int n) {
        int ans[]= new int[n+1];
        ans[0]=0;
        for(int i=1;i<n+1;i++){
            if(i%2==0){
                ans[i]= ans[i/2];
            }else{
                ans[i]= ans[i/2]+1;
            }
        }
       // System.out.println(5>>>1); //unsigned  is positive 0 append krta hai aage
        //System.out.println(-4>>1);  5^111  1 1 ->0
      //  01 10 -> 1
        //00 0
        return ans;
    }
}





