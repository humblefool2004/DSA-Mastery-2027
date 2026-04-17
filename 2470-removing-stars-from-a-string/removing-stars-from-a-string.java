class Solution {
    public String removeStars(String s) {
        StringBuilder sb= new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch=='*')
                sb.setLength(sb.length()-1);
            else
                sb.append(ch);
        }
        return sb.toString();
    }
}


//Stack based approach
// class Solution {
//     public String removeStars(String s) {
//         Stack<Character> st = new Stack<>();
//         for(char ch : s.toCharArray()){
//             if(ch=='*') st.pop();
//             else st.push(ch);
//         }
//         StringBuilder sb = new StringBuilder();
//         while(!st.isEmpty()){
//             sb.append(st.pop());
//         }
//         return sb.reverse().toString();
//     }
// }