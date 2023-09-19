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
    int sum=0;
    public void recurse(TreeNode root, int value) {
        if(root==null)
        {
            return ;
        }
        else if (root.left==null && root.right==null)
        {
            value = value*10 + root.val; 
            sum+= value;
            return ;
        }
        value = value*10 + root.val; 
        recurse(root.left,value); 
        recurse(root.right,value);
    }
    public int sumNumbers(TreeNode root) {
        recurse(root,0);
        return sum;
    }
}