class Solution {
    private Map<Character,String> map;
    public List<String> letterCombinations(String digits) {
        map= new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> ans=new ArrayList<>();
        helper(digits,0,ans,new StringBuilder());
        return ans;
    }

    private void helper(String digits,int i,List<String> ans,StringBuilder sb){
        if(i==digits.length()){
            ans.add(sb.toString());
            return;
        }

        String toExplore= map.get(digits.charAt(i));

        for(char ch : toExplore.toCharArray()){
            sb.append(ch);
            helper(digits,i+1,ans,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}