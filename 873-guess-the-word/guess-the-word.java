/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        
        List<String> list= new ArrayList<>(Arrays.asList(words));
        
        for(int i=0;i<30;i++){
            int bestWorst=10000;
            String guess="";
            for(String word : list){
                int freq[]= new int[7];
                for(String w : list){
                    freq[matches(w,word)]++;
                }
                int worst=0;
                for(int x : freq){
                    worst= x>worst? x:worst;
                }
                if(worst<bestWorst) {
                    bestWorst=worst;
                    guess=word;
                }
            }
            int match= master.guess(guess);
            if(match == 6) return;
            List<String> newL =new ArrayList<>();
            for(String word : list){
                if(matches(word,guess)==match){
                    newL.add(word);
                }
            }
            list=newL;
        }
    }

    private int matches(String a,String b){
        int count=0;
        for(int i=0;i<6;i++){
            if(a.charAt(i)==b.charAt(i)) count++;
        }
        return count;
    }
}