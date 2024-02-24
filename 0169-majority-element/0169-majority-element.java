class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hmap.put(nums[i],  hmap.getOrDefault(nums[i],0)+1);
        }
        int max=-1, ans=0;
        for(Map.Entry<Integer, Integer> entry: hmap.entrySet()){
            if(max<entry.getValue()){
                ans = entry.getKey();
                max = entry.getValue();
            }
        }
        
        return ans;
    }
}