class Solution {

    class Server {
        int index;
        int weight;
        long freeTime;

        Server(int index, int weight) {
            this.index = index;
            this.weight = weight;
            this.freeTime = 0;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = tasks.length;
        int m = servers.length;

        PriorityQueue<Server> freePq = new PriorityQueue<>((a, b) -> {
            if (a.weight != b.weight)
                return Integer.compare(a.weight, b.weight);
            return Integer.compare(a.index, b.index);
        });

        for (int i = 0; i < m; i++) {
            freePq.offer(new Server(i, servers[i]));
        }

        PriorityQueue<Server> busyPq = new PriorityQueue<>((a, b) -> {
            if (a.freeTime != b.freeTime)
                return Long.compare(a.freeTime, b.freeTime);
            if (a.weight != b.weight)
                return Integer.compare(a.weight, b.weight);
            return Integer.compare(a.index, b.index);
        });

        int[] ans = new int[n];

        long currentTime = 0;

        for (int i = 0; i < n; i++) {

            currentTime = Math.max(currentTime, (long) i);

            while (!busyPq.isEmpty() && busyPq.peek().freeTime <= currentTime) {
                freePq.offer(busyPq.poll());
            }

            if (freePq.isEmpty()) {

                currentTime = busyPq.peek().freeTime;

                while (!busyPq.isEmpty() && busyPq.peek().freeTime == currentTime) {
                    freePq.offer(busyPq.poll());
                }
            }

            Server server = freePq.poll();

            ans[i] = server.index;

            server.freeTime = currentTime + tasks[i];

            busyPq.offer(server);
        }

        return ans;
    }
}