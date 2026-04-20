class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int toBuy= tickets[k];
        int answer=0;
        int n=tickets.length;
        for(int i=0;i<=k;i++){
            if(tickets[i]<=toBuy){
                answer+=tickets[i];
            }else{
                answer+=toBuy;
            }
        }
        for(int i=k+1;i<n;i++){
            if(tickets[i]<=toBuy-1){
                answer+=tickets[i];
            }else{
                answer+=toBuy-1;
            }
        }
        return answer;
    }
}