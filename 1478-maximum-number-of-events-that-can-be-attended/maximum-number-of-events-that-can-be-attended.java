// in the pq only the end date is needed, but i used int[] because its cheaper than Integer.
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        
        int eventCount=0;
        int day= events[0][0];
        int i=0;
        while(i<events.length || !pq.isEmpty()){
            while(i<events.length && events[i][0]==day){
                pq.offer(events[i++]);
            }
            
            while(!pq.isEmpty() && pq.peek()[1]<day) pq.poll();

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