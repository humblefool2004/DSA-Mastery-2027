class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length();
        Map<Character,Character> map= new HashMap<>();
        Set<Character> set= new HashSet<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(s.charAt(i)) ){
                if((map.get(s.charAt(i)) != t.charAt(i))) return false;
                continue;
            }
            else{
                if(set.contains(t.charAt(i))) return false;
                map.put(s.charAt(i),t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
    }
}