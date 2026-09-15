class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        // Result array
        int[] result = new int[n - k + 1];

        // Deque stores indexes
        Deque<Integer> dq = new ArrayDeque<>();

        int resultIndex = 0;

        for (int i = 0; i < n; i++) {

            // Remove elements outside the current window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Window has reached size k
            if (i >= k - 1) {
                result[resultIndex] = nums[dq.peekFirst()];
                resultIndex++;
            }
        }

        return result;
    }
}
