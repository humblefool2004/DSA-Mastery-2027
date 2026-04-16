//dual array approach,to avoid sorting 2D array
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals;

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        // Sorting primitives is significantly faster than sorting int[][]
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<int[]> result = new ArrayList<>();
        int startIndex = 0;

        for (int i = 0; i < n; i++) {
            // If the current start is the last one OR 
            // the next start is greater than the current end, we found a gap.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                result.add(new int[]{starts[startIndex], ends[i]});
                startIndex = i + 1;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
/*
//Single array optimization. (91.31,84.95)
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
*/