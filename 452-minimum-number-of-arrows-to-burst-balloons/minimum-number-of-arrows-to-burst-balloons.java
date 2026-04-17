class Solution {
    public int findMinArrowShots(int[][] points) {
        //lets find non overlapping single arrow intervals
        //1 2 7  10
        //6 8 12 16

        //1 3 5 7
        //2 4 6 8

        //1 2 3 4
        //2 3 4 5
        int n= points.length;
        Arrays.sort(points, 
        (a,b)-> Integer.compare(a[1],b[1])
        );

        int i=0;
        int ans=0;
        while(i<n){
            int check= points[i][1];
            ans++;
            i++;
            while(i<n && check>=points[i][0]){
                i++;
                if(i==n) return ans;
            }
        }
        return ans;
    }
}