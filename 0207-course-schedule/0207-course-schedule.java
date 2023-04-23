class Solution {
    HashMap<Integer, HashSet<Integer>> adjMat;
    public boolean dfs(int node, HashSet<Integer> visited)
    {
         if(!adjMat.containsKey(node))
        {
         //   visited.add(node);
            return true;
        }
        if(visited.contains(node))
            return false;
        visited.add(node);
        for(int i : adjMat.get(node))
        {
            if(!dfs(i, visited))
                return false;
        }
        visited.remove(node);
        adjMat.get(node).clear();
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjMat = new HashMap<>();
        for(int[] arr: prerequisites)
        {
            HashSet<Integer> temp = adjMat.getOrDefault(arr[0], new HashSet<>());
            temp.add(arr[1]);
            adjMat.put(arr[0],temp);
        }
        boolean ans = true;
        HashSet<Integer> visited =  new HashSet<>();
        for(int i=0;i<=numCourses;i++)
        {
            ans  = ans & dfs(i, new HashSet<>());
        }
        return ans;
    }
}