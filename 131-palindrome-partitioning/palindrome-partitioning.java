class Solution {

    private List<List<String>> ans;

    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        traverse(0,s,new ArrayList<>());
        return ans;
    }

    private void traverse(int cut,String s, List<String> list){
        if(cut==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=cut+1;i<=s.length();i++){
            String sub= s.substring(cut,i);
            if(checkPallindrome(sub)){
                list.add(sub);
                traverse(i,s,list);
                list.removeLast();
            }
        }
    }

    private boolean checkPallindrome(String s){
        int start=0;
        int end= s.length()-1;
        while(start<end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}