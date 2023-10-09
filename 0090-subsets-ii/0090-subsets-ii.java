class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    
    public void recurse(int[] nums, int ptr, List<Integer> subset) {
        //Collections.sort(subset);
        if(!answer.contains(subset))
            answer.add(new ArrayList<>(subset));
        
        for(int i = ptr; i < nums.length; i++) {
            subset.add(nums[i]);
            recurse(nums, i + 1, subset); 
            subset.remove(subset.size() - 1);
        }
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         if(nums.length == 0)
            return new ArrayList<>();
        Arrays.sort(nums);
        recurse(nums, 0, new ArrayList<>());
        return answer;
    }
}