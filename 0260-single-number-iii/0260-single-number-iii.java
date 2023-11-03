class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        
        for(int i=0;i<nums.length;i++) {
            if(!hset.contains(nums[i])) {
                hset.add(nums[i]);
            }
            else {
                hset.remove(nums[i]);
            }
        }
        
        return hset.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }
}