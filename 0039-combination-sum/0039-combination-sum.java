import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public void backtrack(int[] candidates, int target, int itr, List<Integer> result) {
        if (target == 0) {
            answer.add(new ArrayList<>(result));
            return;
        }

        for (int i = itr; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                result.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i, result);
                result.remove(result.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Arrays.sort(candidates); 
        backtrack(candidates, target, 0, new ArrayList<>());
        return answer;
    }
}
