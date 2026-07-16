class Solution {
    public int reverse(int x) {

        // System.out.println(Integer.MIN_VALUE);//-2147483648
        // System.out.println(Integer.MAX_VALUE); //2147483647
        int rev=0;
        while(x>0){
            if(rev>214748364 ) return 0;
            if(rev==214748364 && x%10>7) return 0;
            System.out.println(x);
            rev= rev*10 + x%10;
            x/=10;
        }

        while(x<0){
            if(rev<-214748364) return 0;
            if(rev==-214748364 && x%10>8) return 0;
            System.out.println(x);
            rev= rev*10 + x%10;
            x/=10;
        }

        return rev;
    }
}