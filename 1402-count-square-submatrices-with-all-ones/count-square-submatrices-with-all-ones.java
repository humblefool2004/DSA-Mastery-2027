class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n= matrix[0].length;

        int dp[][]= new int[m][n];

        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans+=solve(matrix,i,j,dp);
            }
        }
        return ans;
    }

    //solve function returns the size of the largest possible square with all 1s from r,c;
    private int solve(int[][] matrix,int r, int c,int[][] dp){
        if(r==matrix.length || c==matrix[0].length) return 0;
        if(matrix[r][c]==0) return 0;

        if(dp[r][c]!=0) return dp[r][c];
        ////very very imporant part of this recursion.***
        //it tells valid squares on the position right, down,and diag. 
        int right=solve(matrix,r,c+1,dp);
        int down= solve(matrix,r+1,c,dp);
        int diag= solve(matrix,r+1,c+1,dp);

        //here 1 is added because atleast square of size 1 is possible
        return dp[r][c]=1+ Math.min(right,Math.min(down,diag));
    }
}