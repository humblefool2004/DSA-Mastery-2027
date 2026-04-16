//dual array approach,to avoid sorting 2D array
class Solution {
    public int[][] merge(int[][] intervals) {
        int n= intervals.length;
        int start[]=new int[n];
        int end[]=new int[n];
        for(int i=0;i<n;i++){
            start[i]=intervals[i][0];
            end[i]=intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        List<int[]> result = new ArrayList<>();
        int startIndex=0;
        for(int i=0;i<n;i++){
            if(i==n-1 || start[i+1]>end[i]){
                result.add(new int[]{start[startIndex],end[i]});
                startIndex=i+1;
            }
        }
        return result.toArray(new int[result.size()][2]);

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
*/