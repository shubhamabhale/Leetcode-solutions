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
    class TreeNodePos
    {
        public TreeNode node;
        public int position;
        TreeNodePos left;
        TreeNodePos right;
        TreeNodePos(TreeNode val, int pos)
        {
            this.node=val;
            this.position=pos;
        }
    }
   
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNodePos> que = new LinkedList<>();
        TreeNodePos rootPos = new TreeNodePos(root,0);
        que.add(rootPos);
        int res=-1;
        while(!que.isEmpty())
        {
            int count= que.size(); //1 //2
            int nullCnt=0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i=0;i<count;i++)
            {
                TreeNodePos temp = que.poll();
                int currPos = temp.position;
                TreeNode currNode = temp.node;
                if(currNode.left!=null)
                {
                    que.add(new TreeNodePos(currNode.left, 2* currPos+1));
                }
                if(currNode.right!=null)
                {
                    que.add(new TreeNodePos(currNode.right, 2* currPos+2));
                }
                min = Math.min(min, currPos);
                max = Math.max(max,currPos);
            }
            if(min!=Integer.MAX_VALUE && max!=Integer.MIN_VALUE)
            {
                res = Math.max(res, max - min+1);
            }
            
        }
        return res;
    }
}