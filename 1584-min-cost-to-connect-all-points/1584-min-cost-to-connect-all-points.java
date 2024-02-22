class Solution {
    class Edge{
        int u;
        int v;
        int cost;
        public Edge(int u, int v, int cost) {
            this.u=u;
            this.v=v;
            this.cost = cost;
        }
    }
    int[] parent;
    public int find(int x){
        if(x==parent[x])
            return x;
        int res = find(parent[x]);
        parent[x] = res;
        return res;
    }
    public void union(int x, int y){
        int xP = find(x);
        int yP = find(y);
        if(xP==yP)
            return ;
        parent[yP] = xP;
    }
    public int minCostConnectPoints(int[][] points) {
        if(points.length<=1)
            return 0;
        
        List<Edge> edges = new ArrayList<>();
        for(int i=0;i<points.length;i++ )
        {
            for(int j=i+1;j<points.length;j++) {
                int cost = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
            
                Edge e  = new Edge(i, j, cost);
                edges.add(e);
            }
        }
        
        PriorityQueue<Edge> pque = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);
        for(Edge e: edges) {
            pque.offer(e);
        }
        parent  = new int[points.length];
        for(int i=0;i<points.length;i++)
            parent[i] = i;
        
        boolean[] connected = new boolean[points.length];
        Arrays.fill(connected, false);
        int ans =0;
        int count = 1;
       
        while (!pque.isEmpty() && count < points.length) {
           
            Edge e = pque.poll();
            
            if (find(e.u)==find(e.v)) {
                continue;
            }

            union(e.u, e.v);
            ans += e.cost;
            count++;
        }
       
        return ans;
    }
}