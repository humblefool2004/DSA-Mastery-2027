class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq= new PriorityQueue<>(
            (a,b)->
            b[2]-a[2]
        );

        for(int[] p : points){
            int dist=p[0]*p[0] + p[1]*p[1];
            pq.offer(new int[]{p[0],p[1],dist});
            if(pq.size() >k){
                pq.poll();
            }
        }
        int[][] answer =new int[k][2];
        int i=0;
        while(!pq.isEmpty()){
            int p[] = pq.poll();
            answer[i++]= new int[]{p[0],p[1]};
        }
        return answer;
    }
}