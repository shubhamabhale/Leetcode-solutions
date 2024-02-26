class Solution {
    public HashMap<Integer, Integer> dp;

    public int recurse(int target, int maxDoubles, int count) {
        if (target == 1) {
            return count;
        } 
        if(maxDoubles==0)
            return count+ target-1;
        


        int moves;
        if (target % 2 == 1) {
            moves = recurse(target - 1, maxDoubles, count + 1);
        } else {
            moves = recurse(target/2, maxDoubles-1, count + 1);
        }

        //dp.put(target, moves); // Memoize the result
        return moves;
    }

    public int minMoves(int target, int maxDoubles) {
        dp = new HashMap<>();
        if (target == 0)
            return -1;
        return recurse(target, maxDoubles, 0);
    }
}
