class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000"))
            return -1;

        if (target.equals("0000"))
            return 0;

        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();

        begin.add("0000");
        end.add(target);

        int level = 0;

        while (!begin.isEmpty() && !end.isEmpty()) {

            // Always expand the smaller frontier
            if (begin.size() > end.size()) {
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }

            Set<String> next = new HashSet<>();

            for (String curr : begin) {

                if (dead.contains(curr))
                    continue;

                if (end.contains(curr))
                    return level;

                visited.add(curr);

                char[] arr = curr.toCharArray();

                for (int i = 0; i < 4; i++) {

                    char old = arr[i];

                    // -1
                    arr[i] = (char) ('0' + (old - '0' + 9) % 10);
                    String s = String.valueOf(arr);

                    if (!visited.contains(s))
                        next.add(s);

                    // +1
                    arr[i] = (char) ('0' + (old - '0' + 1) % 10);
                    s = String.valueOf(arr);

                    if (!visited.contains(s))
                        next.add(s);

                    arr[i] = old;
                }
            }

            begin = next;
            level++;
        }

        return -1;
    }
}


// class Solution {
//     public int openLock(String[] deadends, String target) {
//         if (target.equals("0000"))
//             return 0;
//         Set<String> set = new HashSet<>(Arrays.asList(deadends));
//         if (set.contains("0000"))
//             return -1;

//         Queue<String> queue = new ArrayDeque<>();

//         queue.offer("0000");
//         set.add("0000");
//         int level = 0;
//         while (!queue.isEmpty()) {
//             int n = queue.size();
//             for (int i = 0; i < n; i++) {
//                 String curr = queue.poll();
//                 if (target.equals(curr))
//                     return level;
//                 char[] arr = curr.toCharArray();
//                 for (int j = 0; j < 4; j++) {
//                     char old = arr[j];

//                     //-1
//                     arr[j] = (char) ('0' + (old - '0' + 9) % 10);
//                     String next = String.valueOf(arr);
//                     if (!set.contains(next)) {
//                         queue.offer(next);
//                         set.add(next);
//                     }

//                     arr[j] = (char) ('0' + (old - '0' + 1) % 10);
//                     next = String.valueOf(arr);
//                     if (!set.contains(next)) {
//                         queue.offer(next);
//                         set.add(next);
//                     }

//                     arr[j]=old;

//                 }
//             }
//             level++;
//         }

//         return -1;
//     }
// }