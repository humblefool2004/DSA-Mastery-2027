class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        int max=0;
        for(char ch : tasks){
            if(++freq[ch-'A'] > max) max=freq[ch-'A'];
        }
        int countFreqMax=0;
        for(int f : freq){
            if(f==max){
                countFreqMax++;
            }
        }
        //Insane greedy approach
        int answer= Math.max(tasks.length, (max-1)*(n+1) +countFreqMax);
        return answer;
    }
}