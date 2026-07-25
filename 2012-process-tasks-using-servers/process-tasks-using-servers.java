class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = tasks.length;
        int m = servers.length;

        PriorityQueue<Integer> freePq = new PriorityQueue<>((a, b) -> {
            if (servers[a] != servers[b]) {
                return Integer.compare(servers[a], servers[b]);
            } else
                return Integer.compare(a, b);
        });
        for (int i = 0; i < m; i++) {
            freePq.add(i);
        }

        //free time, weight, serverid
        PriorityQueue<int[]> busyPq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0])
                        return Integer.compare(a[0], b[0]);
                    else if (a[1] != b[1])
                        return Integer.compare(a[1], b[1]);
                    else
                        return Integer.compare(a[2], b[2]);
                });

        int ans[] = new int[n];

        int currentTime = 0;

        for (int i = 0; i < n;i++) {

            currentTime = Math.max(currentTime, i);

            while (!busyPq.isEmpty() && busyPq.peek()[0] <= currentTime) {
                freePq.add(busyPq.poll()[2]);
            }
            if (freePq.isEmpty()) {
                currentTime = busyPq.peek()[0];
                while (!busyPq.isEmpty() && busyPq.peek()[0] == currentTime) {
                    freePq.add(busyPq.poll()[2]);
                }
            }

            ans[i] = freePq.poll();
            busyPq.add(new int[] { currentTime+tasks[i],servers[ans[i]], ans[i] });
        }
        return ans;
    }
}