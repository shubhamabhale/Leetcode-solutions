class Solution {
    public int maximumWealth(int[][] accounts) {
        if(accounts.length==0)
            return 0;
        int max = -1;
        for(int[] account: accounts)   
        { 
            int x=0;
            for(int j=0;j<account.length;j++)
            {
                x+= account[j];
            }
            max = Math.max(max, x);
        }
        return max;
    }
}