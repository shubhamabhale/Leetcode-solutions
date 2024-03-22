class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
    
    public int recurse(int[] coins,  int target) {
        if(target==0)
            return 0;
        if(dp.containsKey(target))
            return dp.get(target);
        
        int min_cnt = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++) {
           
            if(target>=coins[i]) {
                int res = recurse(coins,  target - coins[i]);
                if(res!=-1) {
                    min_cnt  =  Math.min(1+res, min_cnt);
                }
            }
        }
        dp.put(target, (min_cnt == Integer.MAX_VALUE) ? -1 : min_cnt);
        return dp.get(target);
    }
    public int coinChange(int[] coins, int amount) {
     
        return recurse(coins, amount);
    }

}