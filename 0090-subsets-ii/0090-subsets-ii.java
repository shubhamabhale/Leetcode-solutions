class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();

        Arrays.sort(nums);
        recurse(nums, 0, new ArrayList<>());
        return answer;
    }

    public void recurse(int[] nums, int start, List<Integer> subset) {
        answer.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            subset.add(nums[i]);
            recurse(nums, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
