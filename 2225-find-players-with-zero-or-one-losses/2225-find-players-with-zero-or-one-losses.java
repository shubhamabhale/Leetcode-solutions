class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        TreeMap<Integer, Integer> lostCount = new TreeMap<>();
        for(int[] match: matches) {
            if(!lostCount.containsKey(match[0])) {
                lostCount.put(match[0],0);
            }
            if(!lostCount.containsKey(match[1])) {
                lostCount.put(match[1],1);
            } else {
                lostCount.put(match[1],lostCount.get(match[1])+1);
            }
            
        }
        
        ArrayList<Integer> winners = new ArrayList<>();
        ArrayList<Integer> almost = new ArrayList<>();
        
        for( Map.Entry<Integer, Integer> e : lostCount.entrySet()) {
            if(e.getValue()==0)
                winners.add(e.getKey());
            if(e.getValue()==1)
                almost.add(e.getKey());
        }
        
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(winners));
        answer.add(new ArrayList<>(almost));
        
        return answer;
    }
}