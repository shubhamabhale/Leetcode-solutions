class Solution {
    public int[] runningSum(int[] nums) {
        if(nums.length==0 || nums.length==1)
            return nums;
        
        int prefixSum =0;
        int[] ans = new int[nums.length];
        
        for(int i=0;i<ans.length;i++)
        {
            prefixSum += nums[i];
            ans[i]=prefixSum;
        }
        
        return ans;
    }
}