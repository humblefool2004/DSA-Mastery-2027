class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer= new ArrayList<>();
        generate(0,0,n,new StringBuilder(),answer);
        return answer;
    }

    private void generate(int open, int close, int n,StringBuilder sb,List<String> ans){
        if(open==n && close ==n){
            ans.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append('(');
            generate(open+1,close, n,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            generate(open,close+1, n,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}