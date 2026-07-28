class Solution {
    public int repeatedStringMatch(String a, String b) {
        int[] lps= lpsFinder(b);
        //making sure a>=b;
        StringBuilder sb=new StringBuilder(a);
        int numberOfAppends=1;
        while(sb.length()<b.length()){
            numberOfAppends++;
            sb.append(a);
        }

        int maxAppendPossible=numberOfAppends+1;
        
        int j=0;
        int len=0;
        while(numberOfAppends<=maxAppendPossible){
            while(len<sb.length()){
                if(sb.charAt(len)==b.charAt(j)){
                    len++;
                    j++;
                    if(j==b.length()){
                        return numberOfAppends;
                    }
                }else{
                    if(j!=0){
                        j=lps[j-1];
                    }
                    else{
                        len++;
                    }
                }
            }
            sb.append(a);
            numberOfAppends++;
        }
        return -1;

    }

    private int[] lpsFinder(String s){
        int[] arr= new int[s.length()];
        arr[0]=0;
        int length=0;
        for(int i=1;i<s.length();){
            if(s.charAt(i)==s.charAt(length)){
                arr[i]=  ++length;
                i++;
            }else{
                if(length!=0){
                    length= arr[length-1];
                }else{
                    arr[i++]=0;
                }
            }
        }
        return arr;
    }
}