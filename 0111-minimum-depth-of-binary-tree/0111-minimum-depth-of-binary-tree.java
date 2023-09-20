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
    public int minDepth(TreeNode root) {
       if(root==null)
            return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 1;
        while(!que.isEmpty())
        {
            int cnt = que.size();   
            for(int i=0;i<cnt;i++)
            {
                TreeNode curr = que.remove();
                if(curr.left==null && curr.right==null)
                    return level;
                if(curr.left!=null)
                    que.add(curr.left);
                if(curr.right!=null)
                    que.add(curr.right);
            }
            level++;
        }
        return -1;
    }
}