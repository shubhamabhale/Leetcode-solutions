/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node ==null)
            return node;
        
        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        visited.put(node, new Node(node.val, new ArrayList<>()));
        
        queue.add(node);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            for(Node neighbor: current.neighbors){
                if(!visited.containsKey(neighbor)){
                    Node n = new Node(neighbor.val, new ArrayList<>());
                    visited.put(neighbor, n);
                    queue.add(neighbor);
                }
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}