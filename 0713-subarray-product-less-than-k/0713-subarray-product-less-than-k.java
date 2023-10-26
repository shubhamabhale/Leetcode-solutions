class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int pdct =1, first=0, last=0;
        int ans=0;
        if(k<=1)
            return 0;
        
        while(last<nums.length) {
            pdct = pdct * nums[last];
            
            while(pdct>=k) {
                pdct = pdct /nums[first];
                first++;
            }
            ans += last-first+1;
            last++;
        }
        return ans;
    }
}