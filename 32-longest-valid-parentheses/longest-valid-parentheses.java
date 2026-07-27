class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st= new Stack<>();
        st.push(-1);
        for(int i=0;i<s.length();i++){
            if((st.peek()!=-1) && (s.charAt(st.peek())=='(') &&  (s.charAt(i)==')')) st.pop();
            else st.push(i); 
        }
        int popped=s.length();
        int max=0;
        while(!st.isEmpty()){
            int a= st.pop();
            max= Math.max(popped-a-1,max);
            popped=a;
        }
        return max;
    }
}