class Solution {
    int ans  =-1;
    
    public int recurse(HashMap<Integer, HashSet<Integer>> adjMat, HashSet<Integer> visited, int index){
        if(index>adjMat.size()){
            return 0;
        }
        
        int max1=0, max2=0;
        
        visited.add(index);
        HashSet<Integer> neighbors = adjMat.get(index);
        for(int neighbor: neighbors){
            if(!visited.contains(neighbor)){
                int temp = 1 + recurse(adjMat, visited, neighbor);
                if(temp >= max1){
                    max2=max1;
                    max1=temp;
                }else if(temp > max2){
                     max2=temp;
                }
            }
        }
        ans = Math.max(ans, max1+max2);
        
        return max1;
    }
    public int treeDiameter(int[][] edges) {
        HashMap<Integer, HashSet<Integer>> adjMat = new HashMap<>();
        if(edges.length==0)
            return 0;
        for(int[] edge: edges){
            HashSet<Integer> temp1 = adjMat.getOrDefault(edge[0],new HashSet<>());
            temp1.add(edge[1]);
            adjMat.put(edge[0], temp1);
            
            HashSet<Integer> temp2 = adjMat.getOrDefault(edge[1],new HashSet<>());
            temp2.add(edge[0]);
            adjMat.put(edge[1], temp2);
        }
       
       
        recurse(adjMat, new HashSet<>(), 0);
        
        return ans;
    }
}
