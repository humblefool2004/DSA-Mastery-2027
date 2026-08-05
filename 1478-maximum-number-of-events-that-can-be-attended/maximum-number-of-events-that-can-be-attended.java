class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->
      Integer.compare(a[0],b[0])
        );
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int eventCount=0;
        int day= events[0][0];
        int i=0;
        while(i<events.length || !pq.isEmpty()){
            while(i<events.length && events[i][0]==day){
                pq.offer(events[i++][1]);
            }
            
            while(!pq.isEmpty() && pq.peek()<day) pq.poll();

            if(pq.isEmpty() ){
                if(i<events.length) day= events[i][0];
            }else{
                pq.poll();
                eventCount++;
                day++;
            }
            
        }
        return eventCount;
    }
}