class Solution {
    public int calculate(String s) {
        Stack<Character> ch = new Stack<>();
        Stack<Integer> st = new Stack<>();
        s = s.replaceAll(" ", "");

        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            if (ss == '+' || ss == '-' || ss == '*' || ss == '/') {
                if (ch.isEmpty())
                    ch.push(ss);
                else if (ss == '*' || ss == '/') {
                    while (!ch.isEmpty() && (ch.peek() == '*' || ch.peek() == '/')) {
                        char op = ch.pop();
                        int b = st.pop();
                        int a = st.pop();
                        int res = switch (op) {
                            case '*' -> a * b;
                            case '/' -> a / b;
                            default -> 0;
                        };
                        st.push(res);
                    }
                    ch.push(ss);
                } else {
                    while (!ch.isEmpty()) {
                        char op = ch.pop();
                        int b = st.pop();
                        int a = st.pop();
                        int res = switch (op) {
                            case '*' -> a * b;
                            case '/' -> a / b;
                            case '-' -> a - b;
                            case '+' -> a + b;
                            default -> 0;
                        };
                        st.push(res);
                    }
                    ch.push(ss);
                }
            } else {
                int start = i;
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                }
                String number = s.substring(start, i + 1);
                st.push(Integer.parseInt(number));
            }
        }
        while (!ch.isEmpty()) {
            char op = ch.pop();
            int b = st.pop();
            int a = st.pop();
            int res = switch (op) {
                case '*' -> a * b;
                case '/' -> a / b;
                case '-' -> a - b;
                case '+' -> a + b;
                default -> 0;
            };
            st.push(res);
        }
        return st.peek();
    }
}