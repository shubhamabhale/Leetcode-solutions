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
    int count = 0, ans = -1;
    public void inorder(TreeNode root, int k) {
        if(root==null)
            return ;
        inorder(root.left,k);
        
        System.out.print(root.val +  " ");
        count++;
        if(count==k)
        {
            ans = root.val;
        }   
        inorder(root.right,k);
        
       
    }
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }
}