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
    int res=0;
    public void recurse(TreeNode root, char flag, int steps)
    {
        if(root==null)
            return ;
        if(root.left==null && root.right==null)
        {
            res  = Math.max(steps,res);
            return ;
        }
        if(flag=='l')
        {
            res  = Math.max(steps,res);
            recurse(root.right,'r',steps+1);
            recurse(root.left, 'l',1);
            
        }
        else if(flag=='r')
        {
            res  = Math.max(steps,res);
            recurse(root.left,'l',1+steps);
            recurse(root.right, 'r',1);
           
        }
    }
    public int longestZigZag(TreeNode root) {
        if(root==null)
                return 0;
        int step1 =0;
        
        recurse(root.left,'l',step1+1);
        recurse(root.right,'r',step1+1);
        return res;
    }
}