class Solution {
    List<List<Integer>> answer;
    public void recurse(int[] nums, List<Integer> list)
    {
        if(list.size()==nums.length)
        {
            ArrayList<Integer> temp = new ArrayList<>(list);
            answer.add(temp);
            
        }
        else
            for(int i = 0;i<nums.length;i++)
            {
                if(!list.contains(nums[i]))
                {
                    list.add(nums[i]);
                    recurse(nums,list);
                    list.remove(list.size()-1);

                }
            }
    }
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        recurse(nums,new ArrayList<>());
        return answer;
    }
}