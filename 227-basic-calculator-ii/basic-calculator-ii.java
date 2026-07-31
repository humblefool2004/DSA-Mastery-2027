class Solution {
    public int calculate(String s) {
        Stack<Integer> stack= new Stack<>();
        char prev='+';
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==' ') continue;
            if(Character.isDigit(ch)){
                int start=i;
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    i++;
                }
                int a=Integer.parseInt(s.substring(start,i+1));
                if(prev=='+') stack.push(a);
                else if(prev=='-') stack.push(-a);
                else {
                    int b= stack.pop();
                    if(prev=='*') stack.push(a*b);
                    else stack.push(b/a);
                }
            }else{
                prev= ch;
            }
        }
        int ans=0;
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }
}