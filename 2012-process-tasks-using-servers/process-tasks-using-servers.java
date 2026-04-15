class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> pq= new PriorityQueue<>(
            (a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]
        );
        int extendedServer[][]= new int[servers.length][3];
        for(int i=0;i<servers.length;i++){
            extendedServer[i][0]=servers[i];
            extendedServer[i][1]=i;
            extendedServer[i][2]=0;
            pq.offer(extendedServer[i]);
        }

        PriorityQueue<int[]> remtime=new PriorityQueue<>(
            (a,b)-> {
                if(a[2]!=b[2]) return a[2]-b[2];
                if(a[0]!=b[0]) return a[0]-b[0];
                return a[1]-b[1];
            }
        );

        int[] ans= new int[tasks.length];
        int currTime=0;
        int taskIdx=0;
        while(taskIdx<tasks.length){
            while(!remtime.isEmpty() && remtime.peek()[2]<=currTime){
                pq.offer(remtime.poll());
            }
            while(!pq.isEmpty() && taskIdx<=currTime){
                int[] arr=pq.poll();
                arr[2]=currTime+tasks[taskIdx];
                ans[taskIdx++]=arr[1];
                if(taskIdx==tasks.length) return ans;
                remtime.offer(arr);
            }

            if(pq.isEmpty()) currTime=Math.max(currTime,remtime.peek()[2]);
            else currTime=Math.max(currTime,taskIdx);
            
        }
        return ans;
    }
}