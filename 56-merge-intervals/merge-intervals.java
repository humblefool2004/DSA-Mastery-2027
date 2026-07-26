class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;
        Arrays.sort(intervals,(a,b)-> 
            Integer.compare(a[0],b[0])
        );

        int start=intervals[0][0];
        int end= intervals[0][1];

        List<int[]> list= new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            if(end<intervals[i][0]){
                list.add(new int[]{start,end});
                start= intervals[i][0];
                end= intervals[i][1];
            }else{
                end= Math.max(end,intervals[i][1]);
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][]);


    }
}