class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int[] preq: prerequisites){
            
            HashSet<Integer> temp = adjList.getOrDefault(preq[1], new HashSet<>());
            temp.add(preq[0]);
            adjList.put(preq[1], temp);
            inDegrees[preq[0]]++;
        }
        //System.out.println(Arrays.asList(adjList));
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<numCourses;i++){
            if(inDegrees[i]==0)
            {
                que.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!que.isEmpty()){
            int curr = que.poll();
            visited[curr] = true;
            HashSet<Integer> neighbors = adjList.get(curr);
            if(neighbors!=null && !neighbors.isEmpty()) {
            for(int neighbor : neighbors){
                if(!visited[neighbor]){
                    inDegrees[neighbor]--;
                    //visited[neighbor] = true;
                    if(inDegrees[neighbor]==0)
                        que.add(neighbor);
                }
            }}
            ans.add(curr);
        }
    
        if(ans.size()==numCourses)
        {
            int[] answer = new int[ans.size()];
            for(int i=0;i<numCourses;i++){
                answer[i]= ans.get(i);
            }
            return answer;
        }
        return new int[0];
        
    }
}