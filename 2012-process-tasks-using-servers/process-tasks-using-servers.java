class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = tasks.length;
        int m = servers.length;

        PriorityQueue<Integer> freePq = new PriorityQueue<>((a, b) -> {
            if (servers[a] != servers[b])
                return Integer.compare(servers[a], servers[b]);
            return Integer.compare(a, b);
        });

        for (int i = 0; i < m; i++) {
            freePq.add(i);
        }

        // {freeTime, weight, serverId}
        PriorityQueue<long[]> busyPq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Long.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        });

        int[] ans = new int[n];

        long currentTime = 0;

        for (int i = 0; i < n; i++) {

            currentTime = Math.max(currentTime, (long) i);

            while (!busyPq.isEmpty() && busyPq.peek()[0] <= currentTime) {
                freePq.add((int) busyPq.poll()[2]);
            }

            if (freePq.isEmpty()) {

                currentTime = busyPq.peek()[0];

                while (!busyPq.isEmpty() && busyPq.peek()[0] == currentTime) {
                    freePq.add((int) busyPq.poll()[2]);
                }
            }

            int server = freePq.poll();
            ans[i] = server;

            busyPq.add(new long[]{
                currentTime + tasks[i],
                servers[server],
                server
            });
        }

        return ans;
    }
}