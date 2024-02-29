class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==0)
            return -1;
        
        int ptr = 0;
        int ans =nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]==ans){
                ptr++;
            } else if (ptr==0){
                ans = nums[i];
               
            } else             {
                 ptr--;
            }
        }
        return ans;
    }
}