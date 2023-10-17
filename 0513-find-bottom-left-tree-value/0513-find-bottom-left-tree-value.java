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
    public int findBottomLeftValue(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> que = new LinkedList<>();
        
        que.add(root);
        int cnt=0;
        TreeNode ans = null;
        while(!que.isEmpty()) {
            cnt = que.size();
            for(int i=0;i<cnt;i++) {
                TreeNode temp = que.poll();
                if(i==0)
                    ans = temp;
                if(temp.left!=null)
                    que.add(temp.left);
                if(temp.right!=null)
                    que.add(temp.right);
            }
        }
        return ans.val;
    }
}