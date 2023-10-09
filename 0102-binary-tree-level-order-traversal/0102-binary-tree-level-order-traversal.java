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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
                return new ArrayList<>();
        
        Queue<TreeNode> que = new LinkedList<>();        
        que.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        
        while(!que.isEmpty())
        {
            int count = que.size();
            List<Integer> result = new ArrayList<>();
            for(int i=0;i<count;i++)
            {
                TreeNode current = que.poll();
                result.add(current.val);
                
                if(current.left!=null)
                {
                    que.add(current.left);
                }
                if(current.right!=null)
                {
                    que.add(current.right);
                }
            }
            ans.add(result);
        }
        return ans;
    }
}