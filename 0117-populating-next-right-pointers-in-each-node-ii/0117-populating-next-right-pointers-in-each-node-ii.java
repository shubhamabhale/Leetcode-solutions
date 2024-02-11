/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        
        Queue<Node> que = new LinkedList<>();
        
        que.add(root);
        while(!que.isEmpty()){
            int currSize = que.size();
            
            for(int i=0;i<currSize;i++){
                Node curr = que.poll();
                if(i!=currSize-1){
                    curr.next = que.peek();
                } else {
                    curr.next=null;
                }
                
                if(curr.left!=null)
                {
                    que.add(curr.left);
                }
                if(curr.right!=null)
                {
                    que.add(curr.right);
                }
            }
        }
        
        return root;
    }
}