class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int [][] taskExtended= new int[n][3];
        for(int i=0;i<n;i++){
            taskExtended[i][0]=tasks[i][0];
            taskExtended[i][1]=tasks[i][1];
            taskExtended[i][2]=i;
        }

        Arrays.sort(taskExtended,(a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq= new PriorityQueue<>(
            (a,b)->{
                if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
                return Integer.compare(a[2],b[2]);
            }
        );
        
        int currTime=0;
        int completedTask=0;
        int processedIdx=0;
        int[] answer= new int[n];
        while(completedTask<n){
            if(pq.isEmpty() && currTime<taskExtended[processedIdx][0]){
                currTime=taskExtended[processedIdx][0];
            }

            while(processedIdx<n && taskExtended[processedIdx][0]<=currTime){
                pq.offer(taskExtended[processedIdx]);
                processedIdx++;
            }
            int[] currentTask= pq.poll();
            currTime+=currentTask[1];
            answer[completedTask++]=currentTask[2];
        }
        return answer;
    }
}