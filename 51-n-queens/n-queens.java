class Solution {
    public List<List<String>> solveNQueens(int n) {
        //chess board
        //method to check if the position is valid or not.
        //lets create a method to check the validation of the queen.
        //initial chess board = nXn with all ".";
        //i will represent queen with "Q"
        List<List<String>> ans= new ArrayList<>();
        char[][] board= new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        solve(board,0,n,ans);
        return ans;
    }

    private void solve(char board[][],int start,int n,List<List<String>> ans){
        if(start==n){
                List<String> list= new ArrayList<>();
                for(int m=0;m<n;m++){
                    String str=new String(board[m]);
                    list.add(str);
                }
                ans.add(list);
                return;
        }
        for(int i=0;i<n;i++){
            if(!canPlaceQueen(board,start,i,n)) continue;
            board[start][i]='Q';
            solve(board,start+1,n,ans);
            board[start][i]='.';
        }
    }

    private boolean canPlaceQueen(char board[][],int r,int c,int n){
        for(int i=0;i<r;i++){
            if(board[i][c]=='Q') return false;
        }
        int i=r-1;
        int j=c+1;

        while(i>=0 && j<n){
            if(board[i][j]=='Q') return false;
            i--;
            j++;
        }
        i=r-1;
        j=c-1;
        while(i>=0 && j>=0) {
            if(board[i][j]=='Q') return false;
            i--;
            j--;
        }
        return true;
    }
}