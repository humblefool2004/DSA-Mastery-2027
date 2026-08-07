class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if(intervals.length==1) return 0; 
        Arrays.sort(intervals, (a,b)->{
            if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
            return Integer.compare(b[0],a[0]);
        } 
        );
        
        int ans=0;
        for(int i=1;i<intervals.length;i++){
            int prev=i-1;
            while(i<intervals.length && intervals[prev][1]> intervals[i][0]){
                ans++;
                i++;
            }
        }
        return ans;
    }
}

