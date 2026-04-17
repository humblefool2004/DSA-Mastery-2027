class Solution {
    public int findMinArrowShots(int[][] points) {
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