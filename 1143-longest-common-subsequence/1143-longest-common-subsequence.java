class Solution {
    int[][] dp;
    public int recurse(String text1, String text2, int index1, int index2){
        if(index1>=text1.length() || index2>=text2.length()){
            return 0;
        }
        if(dp[index1][index2]!=-1)
            return dp[index1][index2];
        
        if(text1.charAt(index1)==text2.charAt(index2)){
            return 1 + recurse(text1, text2, index1+1, index2+1);
        }
        dp[index1][index2] = Math.max(recurse(text1, text2, index1+1, index2), recurse(text1, text2, index1, index2+1));
        return dp[index1][index2];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0 || text2.length()==0)
            return 0;
        dp= new int[text1.length()+1][text2.length()+1];
        for(int[] x: dp)
            Arrays.fill(x, -1);
        
        return recurse(text1, text2, 0, 0);
    }
}