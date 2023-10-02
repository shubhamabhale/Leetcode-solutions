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
    public TreeNode recurse(TreeNode root) {
        if(root==null)
        {
            return root;
        }
        TreeNode temp = root.left;
        root.left = recurse(root.right);
        root.right= recurse(temp);
        
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        return recurse(root);
    }
}