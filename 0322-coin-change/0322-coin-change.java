class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
    
    public int recurse(int[] coins, int cnt, int target) {
        if(target==0)
            return cnt;
        if(dp.containsKey(target))
            return dp.get(target);
        
        int min_cnt = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++) {
           
            if(target>=coins[i]) {
                int res = recurse(coins, cnt, target - coins[i]);
                if(res!=-1) {
                    min_cnt  =  Math.min(1+res, min_cnt);
                }
            }
        }
        dp.put(target, (min_cnt == Integer.MAX_VALUE) ? -1 : min_cnt);
        return dp.get(target);
    }
    public int coinChange(int[] coins, int amount) {
        //Arrays.sort(coins);
        reverseArray(coins);
     
        return recurse(coins, 0, amount);
    }


    private static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            // Swap elements at start and end indices
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            // Move indices towards the center
            start++;
            end--;
        }
    }
}