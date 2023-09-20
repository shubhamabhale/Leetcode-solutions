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
    List<List<Integer>> answer = new ArrayList<>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null)
            return answer;

        Queue<TreeNode> que = new LinkedList<>();
        
        que.add(root);
        while(!que.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            int cnt = que.size();
            for(int i=0;i<cnt;i++)
            {
                temp.add(que.peek().val);
                TreeNode curr = que.remove();
                if(curr.left!=null)
                    que.add(curr.left);
                if(curr.right!=null)
                    que.add(curr.right);
            }
            answer.add(temp);
        }
        Collections.reverse(answer);
        return (answer);
    }
}