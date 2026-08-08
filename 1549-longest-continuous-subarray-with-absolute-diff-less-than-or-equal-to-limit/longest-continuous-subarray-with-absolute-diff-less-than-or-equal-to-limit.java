class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxD = new ArrayDeque<>(); // decreasing: front = window max
        Deque<Integer> minD = new ArrayDeque<>(); // increasing: front = window min
        int left = 0, ans = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxD.isEmpty() && maxD.peekLast() < nums[right]) maxD.pollLast();
            maxD.offerLast(nums[right]);
            while (!minD.isEmpty() && minD.peekLast() > nums[right]) minD.pollLast();
            minD.offerLast(nums[right]);

            // the invalid check — same as your brute force's diff > limit
            while (maxD.peekFirst() - minD.peekFirst() > limit) {
                if (maxD.peekFirst() == nums[left]) maxD.pollFirst();
                if (minD.peekFirst() == nums[left]) minD.pollFirst();
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
