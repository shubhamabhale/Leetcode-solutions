class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
        if(roads.length==0)
            return 0;
        for (int[] road : roads) {
            HashSet<Integer> set1 = adjList.getOrDefault(road[0], new HashSet<>());
            set1.add(road[1]);
            adjList.put(road[0], set1);

            HashSet<Integer> set2 = adjList.getOrDefault(road[1], new HashSet<>());
            set2.add(road[0]);
            adjList.put(road[1], set2);
        }
        
        int answer =-1;
      
        for(Map.Entry<Integer, HashSet<Integer>> e1: adjList.entrySet()){
            for(Map.Entry<Integer, HashSet<Integer>> e2: adjList.entrySet()){
                if(e1.getKey()!=e2.getKey()){
                    int current =0;
                    current += e1.getValue().size();
                    current += e2.getValue().size();
                    
                    if(e1.getValue().contains(e2.getKey())){
                        current--;
                    }
                    answer = Math.max(answer, current);
                }
            }
        }
        
       
        return answer;
    }
}