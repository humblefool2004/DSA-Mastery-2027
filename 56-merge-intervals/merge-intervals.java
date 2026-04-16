
//Single array optimization. (91.31,84.95)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, 
        (a,b)-> a[0]-b[0]
        );

        int n=intervals.length;
        int[] currInterval = intervals[0];
        List<int[]> ans= new ArrayList<>();
        for(int i=1;i<n;i++){
            if(currInterval[1]>=intervals[i][0]){
                currInterval[1] = Math.max(currInterval[1],intervals[i][1]);
            }else{
                ans.add(currInterval);
                currInterval=intervals[i];
            }
        }
        ans.add(currInterval);
        return ans.toArray(new int[ans.size()][2]);
    }
}
