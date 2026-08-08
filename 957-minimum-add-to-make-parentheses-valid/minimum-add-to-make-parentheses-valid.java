class Solution {
    public int minAddToMakeValid(String s) {
        int open=0;
        int close=0;
        for(char ch : s.toCharArray()){
            if(open!=0 && ch==')'){
                open--;
            }else{
                if(ch=='(') open++;
                else close++;
            }
        }
        return open+close;
    }
}

//stack approach
// class Solution {
//     public int minAddToMakeValid(String s) {
//         Stack<Character> st= new Stack<>();
//         for(char ch : s.toCharArray()){
//             if(!st.isEmpty() && st.peek()=='(' && ch==')'){
//                 st.pop();
//             }else st.push(ch);
//         }
//         return st.size();
//     }
// }