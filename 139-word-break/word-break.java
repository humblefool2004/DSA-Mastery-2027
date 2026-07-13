class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictS = new HashSet<>(wordDict);
        Boolean memo[]= new Boolean[s.length()];
        return solve(s,0,wordDictS,memo);

    }

    private boolean solve(String s, int start,Set<String> wordDict,Boolean memo[]){
        if(start==s.length()){
            return true;
        }
        if(memo[start]!=null){
            return memo[start];
        }
        for(int i=start;i<s.length();i++){
            String sub= s.substring(start,i+1);
                if(wordDict.contains(sub) && solve(s,i+1,wordDict,memo)){
                    memo[start]=true;
                    return true;
                }
        }
        memo[start]=false;
        return false;
    }
}