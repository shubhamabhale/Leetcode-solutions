class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
    public int climbStairs(int n) {
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(dp.containsKey(n-1))
            return dp.get(n-1);
        dp.put(n-1, climbStairs(n-1) + climbStairs(n-2));
        return dp.get(n-1);
    }
}