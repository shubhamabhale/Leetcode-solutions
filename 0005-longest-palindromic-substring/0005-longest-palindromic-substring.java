class Solution {
    public String longestPalindrome(String s) {
        
        if(s.length()==0)
            return "";
        int n = s.length();
        int[] ans = new int[]{0,0};
        
        int[][] dp = new int[n][n];
        
        for(int[] temp: dp){
            Arrays.fill(temp,-1);
        }
        
        //1 char is palindrome
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        
        //check for even palindromes
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = 1;
                dp[i+1][i]=1;
                ans[0]=i;
                ans[1]=i+1;
            }
        }
        
        for(int diff =2 ; diff<n ;diff++){
            for(int i=0;i<n - diff;i++){
                int j = i+diff;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    ans[0]=i;
                    ans[1]=j;
                    dp[i][j]=1;
                }
            }
        }
        return s.substring(ans[0],ans[1]+1);
    }
}