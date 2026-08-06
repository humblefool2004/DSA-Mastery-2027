class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000"))
            return 0;
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(deadends)); //works as a visited set too.
        if (set.contains("0000"))
            return -1;

        Queue<String> queue = new ArrayDeque<>();

        queue.offer("0000");
        set.add("0000");
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String curr = queue.poll();
                if (target.equals(curr))
                    return level;
                char[] arr = curr.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char old = arr[j];

                    //-1
                    arr[j] = (char) ('0' + (old - '0' + 9) % 10);
                    String next = String.valueOf(arr);
                    if (!set.contains(next)) {
                        queue.offer(next);
                        set.add(next);
                    }

                    arr[j] = (char) ('0' + (old - '0' + 1) % 10);
                    next = String.valueOf(arr);
                    if (!set.contains(next)) {
                        queue.offer(next);
                        set.add(next);
                    }

                    arr[j]=old;

                }
            }
            level++;
        }

        return -1;
    }
}