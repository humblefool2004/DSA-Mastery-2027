class Solution {
    public int calculate(String s) {
        int result=0; //final answer;
        char op = '+'; //last operator
        int lastNum = 0; //lastNumber   
        int currNum=0; //current Number
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }
            if((!Character.isDigit(ch) && ch!=' ') || (i == s.length() - 1) ){

                if (op == '+') {
                    result+=lastNum;
                    lastNum=currNum;
                } else if (op == '-') {
                    result+=lastNum;
                    lastNum= -currNum;
                } else if (op == '*') {
                    lastNum= lastNum*currNum;
                } else if (op == '/') {
                    lastNum=lastNum/currNum;
                }
                op = ch;
                currNum = 0;
            }
        }

        return result+lastNum;
    }
}

//Overly Engineered approach
// class Solution {
//     public int calculate(String s) {
//         Stack<Character> ch = new Stack<>();
//         Stack<Integer> st = new Stack<>();
//         s = s.replaceAll(" ", "");

//         for (int i = 0; i < s.length(); i++) {
//             char ss = s.charAt(i);
//             if (ss == '+' || ss == '-' || ss == '*' || ss == '/') {
//                 if (ch.isEmpty())
//                     ch.push(ss);
//                 else if (ss == '*' || ss == '/') {
//                     while (!ch.isEmpty() && (ch.peek() == '*' || ch.peek() == '/')) {
//                         char op = ch.pop();
//                         int b = st.pop();
//                         int a = st.pop();
//                         int res = switch (op) {
//                             case '*' -> a * b;
//                             case '/' -> a / b;
//                             default -> 0;
//                         };
//                         st.push(res);
//                     }
//                     ch.push(ss);
//                 } else {
//                     while (!ch.isEmpty()) {
//                         char op = ch.pop();
//                         int b = st.pop();
//                         int a = st.pop();
//                         int res = switch (op) {
//                             case '*' -> a * b;
//                             case '/' -> a / b;
//                             case '-' -> a - b;
//                             case '+' -> a + b;
//                             default -> 0;
//                         };
//                         st.push(res);
//                     }
//                     ch.push(ss);
//                 }
//             } else {
//                 int start = i;
//                 while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
//                     i++;
//                 }
//                 String number = s.substring(start, i + 1);
//                 st.push(Integer.parseInt(number));
//             }
//         }
//         while (!ch.isEmpty()) {
//             char op = ch.pop();
//             int b = st.pop();
//             int a = st.pop();
//             int res = switch (op) {
//                 case '*' -> a * b;
//                 case '/' -> a / b;
//                 case '-' -> a - b;
//                 case '+' -> a + b;
//                 default -> 0;
//             };
//             st.push(res);
//         }
//         return st.peek();
//     }
// }