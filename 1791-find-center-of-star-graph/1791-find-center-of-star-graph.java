class Solution {
    public int findCenter(int[][] edges) {
        if(edges.length==0)
            return -1;
        int[] inDegree = new int[edges.length+2];
        for(int[] edge: edges){
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        for(int i=1;i<edges.length+2;i++){
            if(inDegree[i]!=1)
                return i;
        }
        System.out.println(Arrays.toString(inDegree));
        return -1;
    }
}