//further optimization...
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapS=new int[256];
        int[] mapT=new int[256];

        //here we are checking the last seen (clever trick.)
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(mapS[c1]!=mapT[c2]) return false;
            mapS[c1] = i+1;
            mapT[c2]=i+1;
        }
        return true;
    }
}

// //using array instead of map
// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         int[] mapS=new int[256];
//         int[] mapT=new int[256];

//         for(int i=0;i<s.length();i++){
//             char c1=s.charAt(i);
//             char c2=t.charAt(i);
//             if(mapS[c1]==0 && mapT[c2]==0){
//                 mapS[c1]=c2;
//                 mapT[c2]=c1;
//             }else {
//                 if(mapT[c2]!=c1) return false;
//             }
//         }
//         return true;
//     }
// }

//Map+set approach
/*
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length();
        Map<Character,Character> map= new HashMap<>();
        Set<Character> set= new HashSet<>();
        for(int i=0;i<n;i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1) ){
                if(map.get(c1) != c2) return false;
            }
            else{
                if(set.contains(c2)) return false;
                map.put(c1,c2);
                set.add(c2);
            }
        }
        return true;
    }
}
*/