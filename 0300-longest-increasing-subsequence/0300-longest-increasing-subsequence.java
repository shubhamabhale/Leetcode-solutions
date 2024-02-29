import java.util.Arrays;

class Solution {
    int[] memo;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1); // Initialize memoization array with -1 (indicating not computed)

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, findLIS(nums, i));
        }
        return maxLength;
    }

    private int findLIS(int[] nums, int currentIndex) {
        if (currentIndex == nums.length) {
            return 0; // Base case: reached end of the array
        }

        if (memo[currentIndex] != -1) {
            return memo[currentIndex]; // Return memoized result if available
        }

        int maxLength = 1; // Minimum length of LIS is 1 (current element itself)
        for (int i = currentIndex + 1; i < nums.length; i++) {
            if (nums[i] > nums[currentIndex]) {
                maxLength = Math.max(maxLength, 1 + findLIS(nums, i));
            }
        }

        memo[currentIndex] = maxLength; // Memoize the result
        return maxLength;
    }
}
