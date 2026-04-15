class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] taskExtended = new int[n][3];

        for (int i = 0; i < n; i++) {
            taskExtended[i][0] = tasks[i][0];
            taskExtended[i][1] = tasks[i][1];
            taskExtended[i][2] = i;
        }

        Arrays.sort(taskExtended, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]
        );

        long currTime = 0;
        int processedIdx = 0, completedTask = 0;
        int[] answer = new int[n];

        while (completedTask < n) {

            if (pq.isEmpty() && processedIdx < n && currTime < taskExtended[processedIdx][0]) {
                currTime = taskExtended[processedIdx][0];
            }

            while (processedIdx < n && taskExtended[processedIdx][0] <= currTime) {
                pq.offer(taskExtended[processedIdx++]);
            }

            int[] task = pq.poll();
            currTime += task[1];
            answer[completedTask++] = task[2];
        }

        return answer;
    }
}