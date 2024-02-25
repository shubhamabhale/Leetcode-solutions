class Solution {
    public int recurse(int n, int limit, int children){
        if(children==0){
            if(n==0)
                return 1;
            return 0;
        }
        
        int ans = 0;
        int range = Math.min(n, limit);
        for(int i=range;i>=0;i--){
            ans += recurse(n-i, limit, children-1);
        }
        return ans;
    }
    public int distributeCandies(int n, int limit) {
        return recurse(n, limit, 3);
    }
}