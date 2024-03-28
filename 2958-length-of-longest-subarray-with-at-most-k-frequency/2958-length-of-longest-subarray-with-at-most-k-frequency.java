class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int start = 0, end =0;
        if(nums.length==0){
           return 0; 
        }
        if(nums.length==1)
            return k==1?k:0;
        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        
        while(end<nums.length){
            if(!hmap.containsKey(nums[end])){
                hmap.put(nums[end], 0);
            } else {
              if(hmap.get(nums[end])>=k){
                  hmap.put(nums[start], hmap.get(nums[start])-1);
                  start++;
              } else {
                  hmap.put(nums[end], hmap.get(nums[end])+1);
                  end++;
              } 
                
            }
            ans = Math.max(ans, end-start);
        }
        return ans;
    }
}