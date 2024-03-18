/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root ==null)
            return new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> que = new LinkedList<>();
        Map<Integer, List<Integer>> column = new TreeMap<>();
        
        que.add(new Pair(root, 0));
        
        while(!que.isEmpty()){
            Pair<TreeNode, Integer> current = que.poll();
            
            List<Integer> temp = column.getOrDefault(current.getValue(), new ArrayList<>());
            temp.add(current.getKey().val);
            column.put(current.getValue(), temp);
            
            if(current.getKey().left!=null){
                int lvl = current.getValue()-1;
                Pair<TreeNode, Integer> p = new Pair(current.getKey().left, lvl);
                que.add(p);
            }
            if(current.getKey().right!=null){
                int lvl = current.getValue()+1;
                Pair<TreeNode, Integer> p = new Pair(current.getKey().right, lvl);
                que.add(p);
            }
        }
        
        for(Map.Entry<Integer, List<Integer>> e: column.entrySet()){
            answer.add(e.getValue());
        }
        return answer;
    }
}