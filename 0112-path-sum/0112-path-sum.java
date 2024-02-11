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
    
    public boolean recurse(TreeNode root, int target) {
        
        if((root.left == null && root.right==null) && (target-root.val)==0)
            return true;
        
        
        boolean l=false,r=false;
        if(root.left!=null)
            l = recurse(root.left, target - root.val);
        if(root.right!=null)
            r = recurse(root.right, target - root.val);
        
        return l || r;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        
        return recurse(root, targetSum);
    }
}