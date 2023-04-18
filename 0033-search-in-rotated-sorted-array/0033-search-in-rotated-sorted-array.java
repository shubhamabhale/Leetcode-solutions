class Solution {
public int search(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        int p = i;
        if (nums[n - 1] == target) {
            return n - 1;
        }
        if (i == n - 1) {
            return mid(nums, 0, n - 1, target);
        }

        if (nums[p] == target) {
            return p;
        }
        if (nums[p + 1] == target) {
            return p + 1;
        }
        // target is in the range [nums[0], nums[p]] or [nums[p+1], nums[n-1]]
        if (nums[0] <= target && target < nums[p]) {
            return mid(nums, 0, p - 1, target);
        } else {
            return mid(nums, p + 1, n - 1, target);
        }     
    }

    private int mid(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int index = (l + r) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] > target) {
                r = index - 1;
            } else if (nums[index] < target) {
                l = index + 1;
            }
        }
        return -1;
    }
    
}