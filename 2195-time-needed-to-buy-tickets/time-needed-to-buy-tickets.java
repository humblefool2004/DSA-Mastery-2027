class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time=0;
        for(int i=0;i<k;i++){
            if(tickets[i]<=tickets[k])
                time+= tickets[i];
            else
                time+=tickets[k];
        }

        time+= tickets[k];
        for(int i=k+1;i<tickets.length;i++){
            if(tickets[i]<tickets[k])
                time+=tickets[i];
            else time += tickets[k]-1;
        }
        return time;
    }
}