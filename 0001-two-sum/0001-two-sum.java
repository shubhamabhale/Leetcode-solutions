class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hset = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(hset.containsKey(nums[i]) && i!=hset.get(nums[i])){
                return new int[]{hset.get(nums[i]), i};
            }
            hset.put(target- nums[i], i);
        }
        return new int[]{0,0};
    }
}