class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n=heights.length;
        //core problem aha moment- jump greedily then use bricks for minimun jump.
        PriorityQueue<Integer> minpq=new PriorityQueue<>();

        for(int i=0;i<n-1;i++){
            int heightDiff=heights[i+1]-heights[i];
            if(heightDiff>0){
                minpq.add(heightDiff);
                if(minpq.size()>ladders){
                    int brick=minpq.poll();
                    bricks = bricks-brick;
                }
                if(bricks<0) return i;
            }
        }
        return n-1;
    }
}