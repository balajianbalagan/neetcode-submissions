class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxSum = Integer.MIN_VALUE;   // max subarray (Kadane)
        int minSum = Integer.MAX_VALUE;   // min subarray (Kadane)
        int currMax = 0, currMin = 0;

        for (int num : nums) {
            total += num;

            // Kadane for maximum
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            // Kadane for minimum
            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }

        // If all numbers are negative, minSum == total → wrapping would give 0
        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, total - minSum);
    }
}