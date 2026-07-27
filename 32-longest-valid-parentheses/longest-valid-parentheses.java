class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st= new Stack<>();
        List<Integer> invalid= new ArrayList<>();
        invalid.add(-1);
        for(int i=0;i<s.length();i++){
            if((s.charAt(i))=='(') st.push(i);
            else if((s.charAt(i))==')' && st.isEmpty()) invalid.add(i);
            else st.pop(); 
        }
        System.out.println(invalid);
        while(!st.isEmpty()){
            invalid.add(st.pop());
        }
        System.out.println(invalid);
        Collections.sort(invalid);
        invalid.add(s.length());
        int max=0;
        if(invalid.size()==0) return s.length();
        for(int i=1;i< invalid.size();i++){
            int a = invalid.get(i)-invalid.get(i-1) -1;
            if(a>max) max=a;
        }
        System.out.println(invalid);
        return max;
    }
}