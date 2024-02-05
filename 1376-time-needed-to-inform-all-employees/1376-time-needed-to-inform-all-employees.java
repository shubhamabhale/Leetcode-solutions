class Solution {
    public int dfs(HashMap<Integer, Integer> dp, HashMap<Integer, HashSet<Integer>> adjList, int person, int[] informTime) {
        if(!adjList.containsKey(person) || (adjList.get(person).size()==0))
            return 0;
        
        if(dp.containsKey(person)) {
            return dp.get(person);
        }
        
        HashSet<Integer> temp = adjList.get(person);
        int max =-1;
        
        for(int i: temp) {
            max = Math.max(max, informTime[person] + dfs(dp, adjList, i, informTime));
        }
        
        dp.put(person, max);
        return dp.get(person);
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
        HashMap<Integer, Integer> dp = new HashMap<>();
        
        
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adjList.computeIfAbsent(manager[i], k -> new HashSet<>()).add(i);
            }
        }
        
        return dfs(dp, adjList, headID, informTime);
    }
}