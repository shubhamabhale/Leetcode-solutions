class Solution {
    int answer = -1;
    public void dfs(int[] edges, int index, HashSet<Integer> visited, HashSet<Integer> extra, HashMap<Integer, Integer> distances, int distance) {

        if(edges[index]!=-1) {
            if(!visited.contains(index)) {
                visited.add(index);
                extra.add(index);
                distances.put(index, distance);
                dfs(edges, edges[index], visited, extra, distances, distance+1);
            }
            else if(extra.contains(index)) {
                answer = Math.max(answer, distance - distances.get(index));
            }
            
        }
        extra.remove(index);
    }
    public int longestCycle(int[] edges) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> extra = new HashSet<>();
     
        HashMap<Integer, Integer> distances = new HashMap<>();
        
        for(int i=0;i<edges.length;i++) {
            if(!visited.contains(i)) {
                dfs(edges, i, visited, extra, distances, 0);
            }
        }
        
        return answer;
        
    }
}