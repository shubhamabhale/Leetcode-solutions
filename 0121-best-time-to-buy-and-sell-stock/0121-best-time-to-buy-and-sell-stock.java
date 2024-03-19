class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;
        int max  = -1;
        int n = prices.length;
        int[] maxArr =new int[n];
        maxArr[n-1] = prices[n-1];
        for(int i=prices.length-2;i>=0;i--){
            maxArr[i]= Math.max(maxArr[i+1], prices[i]);
        }
        //System.out.println(Arrays.toString(maxArr));
        for(int i=0;i<n;i++){
            max = Math.max(max, maxArr[i]-prices[i]);
        }
        return max;
    }
}