class Solution {
    public int repeatedStringMatch(String a, String b) {
        int[] lps = lpsFinder(b);

        int numberOfAppends = 1;
        while (numberOfAppends * a.length() < b.length()) {
            numberOfAppends++;
        }

        StringBuilder sb = new StringBuilder(a.length() * (numberOfAppends + 1));
        for (int i = 0; i < numberOfAppends + 1; i++) {
            sb.append(a);
        }

        int j = 0;
        int len = 0;
        int limit = numberOfAppends * a.length();

        while (len < sb.length()) {

            if (sb.charAt(len) == b.charAt(j)) {
                len++;
                j++;

                if (j == b.length()) {
                    if (len <= limit)
                        return numberOfAppends;
                    return numberOfAppends + 1;
                }

            } else {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    len++;
                }

            }
        }

        return -1;
    }

    private int[] lpsFinder(String s) {
        int[] arr = new int[s.length()];
        int length = 0;

        for (int i = 1; i < s.length();) {

            if (s.charAt(i) == s.charAt(length)) {
                arr[i] = ++length;
                i++;
            } else {

                if (length != 0) {
                    length = arr[length - 1];
                } else {
                    arr[i++] = 0;
                }

            }
        }

        return arr;
    }
}