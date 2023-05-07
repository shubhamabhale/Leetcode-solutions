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
    public ArrayList<TreeNode> pre;
    public void preOrder(TreeNode root)
    {
        if(root==null)
                return ;
        pre.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
    public TreeNode recurse(TreeNode root)
    {
        if(root==null )
        {
            return null;
        }
        TreeNode temp = null;
        if(root.right!=null)
        {
            temp = root.right;
        }
        root.right = recurse(root.left);
        root.left=null;
        root = recurse(root.right);
        root.right = temp;
        
        return root;
    }
        
    public void flatten(TreeNode root) {
        if(root==null) 
            return ;
        pre = new ArrayList<>();
        preOrder(root);
        
        for(int i=0;i<pre.size()-1;i++)
        {
            TreeNode temp = pre.get(i);
            temp.left = null;
            temp.right = pre.get(i+1);
        }
    }
}