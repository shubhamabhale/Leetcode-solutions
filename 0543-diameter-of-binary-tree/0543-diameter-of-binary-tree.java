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
    public int maxHeight(TreeNode root) {
        if(root==null)
            return 0;
        
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
                return 0;
        
        
       int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        int rootDiameter = maxHeight(root.left) + maxHeight(root.right);

        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }
}