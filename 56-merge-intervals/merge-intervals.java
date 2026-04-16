class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, 
        (a,b)-> a[0]-b[0]
        );

        int n=intervals.length;
        int[] currInterval = new int[]{
            intervals[0][0],
            intervals[0][1]
        };
        int[][] ans= new int[n][2];
        int intervalCount=0;
        for(int i=1;i<n;i++){
            if(currInterval[1]>=intervals[i][0]){
                currInterval[1] = Math.max(currInterval[1],intervals[i][1]);
            }else{
                ans[intervalCount++]=currInterval;
                currInterval=new int[]{
                    intervals[i][0],
                    intervals[i][1]
                };
            }
        }
        ans[intervalCount++]=currInterval;
        return Arrays.copyOfRange(ans,0,intervalCount);
    }
}