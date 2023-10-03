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
    int answer=0;
    public int recurse(TreeNode root, int max) {
        if(root==null)
            return 0;
        if(root.val>=max){
            max = root.val;
            answer++;
        }
        recurse(root.left, max);
        recurse(root.right, max);
        return max;
    }
    public int goodNodes(TreeNode root) {
        if(root==null) 
            return 0;
        if(root.left==null && root.right==null) {
            return 1;
        } 
        recurse(root,Integer.MIN_VALUE);
        return answer;
    }
}