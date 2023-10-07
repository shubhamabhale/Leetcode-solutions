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
    int ans =Integer.MIN_VALUE;
    public int maxSum(TreeNode root) {
        if(root==null)
            return 0;

        int l = Math.max(maxSum(root.left),0);
        int r = Math.max(maxSum(root.right),0);
        
        ans = Math.max(ans, root.val + l+r);
        return Math.max(l+root.val, r + root.val);
    }
    public int maxPathSum(TreeNode root) {
         maxSum(root);
        return ans;
    }
}