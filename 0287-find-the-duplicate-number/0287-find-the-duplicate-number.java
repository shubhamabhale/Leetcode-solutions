class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        
        for(int i=0;i<nums.length;i++)
        {
            if(!visited[nums[i]])
            {
                visited[nums[i]]=true;
            }
            else
            {
                return nums[i];
            }
        }
        return -1;
    }
}