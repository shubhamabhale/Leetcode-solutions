/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode contains(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p) {
            return p;
        }
        if(root==q) {
            return q;
        }
        TreeNode left = contains(root.left,p,q);
        TreeNode right = contains(root.right,p,q);
        if(left!=null && right!=null)
        {
            return root;
        }
        return left!=null?left:right;
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        return contains(root,p,q);
    }
}