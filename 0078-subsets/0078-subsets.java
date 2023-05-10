class Solution {
    List<List<Integer>> answer;
    public void recurse(int[]nums, List<Integer> temp, int index)
    {
    answer.add(new ArrayList<>(temp));
    for(int i=index;i<nums.length;i++)
    {
        temp.add(nums[i]);
        recurse(nums,temp, i+1);
        temp.remove(temp.size()-1);
    }
    
    }
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<>();
        Arrays.sort(nums);
        recurse(nums,new ArrayList<>(),0);
        return answer;
    }
}