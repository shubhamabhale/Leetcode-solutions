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
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null)
        {
            return false;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        ArrayList<TreeNode> even = new ArrayList<>();
        ArrayList<TreeNode> odd = new ArrayList<>();
        int level =-1;
        while(!que.isEmpty())
        {
            level++;
            int count = que.size();
            for(int i=0;i<count;i++)
            {
                TreeNode temp = que.poll();
                System.out.print(temp.val + " ");
                if(level%2==0)
                {
                    even.add(temp);
                }
                else
                {
                    odd.add(temp);
                }
                if(temp.left!=null)
                {
                    //System.out.print(temp.left.val + " ");
                    que.add(temp.left);
                }
                if(temp.right!=null)
                {
                    que.add(temp.right);
                }
            }
            System.out.println();
            if(even.size()==1)
            {
                if(even.get(0).val%2!=1)
                    return false;
                even.clear();
                continue;
            }
            for(int i=0;i<even.size()-1;i++)
            {
                System.out.print(even.size() + "even.size()");
                
                if(even.get(i).val%2!=1 || even.get(i+1).val%2!=1)
                {
                    return false;
                }
                if(even.get(i).val>=even.get(i+1).val)
                {
                    return false;
                }
            }
            if(odd.size()==1)
            {
                if(odd.get(0).val%2!=0)
                    return false;
                odd.clear();
                continue;
            }
            for(int i=0;i<odd.size()-1;i++)
            {
                System.out.print(odd.size() + "odd.size()");
                //System.out.print("odd.get(i+1).val = " + odd.get(i+1).val +  " ");
                if(odd.get(i).val%2!=0 || odd.get(i+1).val%2!=0)
                {  
                    return false;
                }
                if(odd.get(i).val<=odd.get(i+1).val)
                {
                    return false;
                }
            }
            even.clear();
            odd.clear();
        }
        return true;
    }
}