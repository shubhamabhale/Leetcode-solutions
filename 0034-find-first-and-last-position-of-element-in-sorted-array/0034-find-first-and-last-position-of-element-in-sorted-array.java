class Solution {
    public int binSearch(int[] nums, int target, int start, int end)
    {
        if(start<=end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]> target)
                return binSearch(nums, target, start, mid-1);
            else 
                return binSearch(nums, target, mid+1, end);
        }
        else
            return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int s = binSearch(nums, target, 0, nums.length-1);
        while(s>0 && nums[s-1]==target)
        {
            s--;
        }
        int e = s;
        if(s!=-1)
        {
            
            while(e<nums.length-1 && nums[e+1]==target)
            {
                e++;
            }
        }
        int[] ans = new int[2];
        ans[0]=s;
        ans[1]=e;

        return ans;
    }
}