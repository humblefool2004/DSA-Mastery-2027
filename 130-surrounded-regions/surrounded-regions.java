//multisource dfs
class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visited= new boolean[m][n];
        Queue<int[]> queue= new ArrayDeque<>();
        for(int i=0;i<m;i++){
            if(!visited[i][0] && board[i][0]=='O'){
                queue.offer(new int[]{i,0});
                visited[i][0]=true;
            } 
            if(!visited[i][n-1] && board[i][n-1]=='O'){
                queue.offer(new int[]{i,n-1});
                visited[i][n-1]=true;
            }
        }
        for(int j=0;j<n;j++){
            if(!visited[0][j] && board[0][j]=='O'){
                queue.offer(new int[]{0,j});
                visited[0][j]=true;
            } 
            if(!visited[m-1][j] && board[m-1][j]=='O'){
                queue.offer(new int[]{m-1,j});
                visited[m-1][j]=true;
            } 
        }

        while(!queue.isEmpty()){
            int k= queue.size();
            for(int i=0;i<k;i++){
                int[] a= queue.poll();
                if(a[0]!=0 && !visited[a[0]-1][a[1]] && board[a[0]-1][a[1]]=='O'){
                    queue.offer(new int[]{a[0]-1,a[1]});
                    visited[a[0]-1][a[1]]=true;
                }
                if(a[0]!=m-1 && !visited[a[0]+1][a[1]] && board[a[0]+1][a[1]]=='O'){
                    queue.offer(new int[]{a[0]+1,a[1]});
                    visited[a[0]+1][a[1]]=true;
                }

                if(a[1]!=0 && !visited[a[0]][a[1]-1] && board[a[0]][a[1]-1]=='O'){
                    queue.offer(new int[]{a[0],a[1]-1});
                    visited[a[0]][a[1]-1]=true;
                }

                if(a[1]!=n-1 && !visited[a[0]][a[1]+1] && board[a[0]][a[1]+1]=='O'){
                    queue.offer(new int[]{a[0],a[1]+1});
                    visited[a[0]][a[1]+1]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]) board[i][j]='X';
            }
        }   
    }
}