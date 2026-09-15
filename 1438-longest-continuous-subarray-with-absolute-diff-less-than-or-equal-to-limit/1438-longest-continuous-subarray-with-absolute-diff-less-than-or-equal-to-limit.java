

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        // Stores indexes of elements in decreasing order
        Deque<Integer> maxDeque = new ArrayDeque<>();

        // Stores indexes of elements in increasing order
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain decreasing order for maximum
            while (!maxDeque.isEmpty() &&
                   nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }

            maxDeque.offerLast(right);

            // Maintain increasing order for minimum
            while (!minDeque.isEmpty() &&
                   nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }

            minDeque.offerLast(right);

            // If max - min is greater than limit,
            // move left pointer
            while (nums[maxDeque.peekFirst()]
                   - nums[minDeque.peekFirst()] > limit) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            // Current valid window length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
