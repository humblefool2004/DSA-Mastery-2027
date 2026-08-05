class Solution {
    public int maxEvents(int[][] events) {

        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int eventCount = 0;
        int day = events[0][0];
        int i = 0;

        while (i < events.length || !pq.isEmpty()) {

            // Add all events starting today
            while (i < events.length && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            // Remove expired events
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // Attend one event
            if (!pq.isEmpty()) {
                pq.poll();
                eventCount++;
                day++;
            } else if (i < events.length) {
                // Jump to the next event's start day
                day = events[i][0];
            }
        }

        return eventCount;
    }
}