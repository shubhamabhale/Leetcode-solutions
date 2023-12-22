class Solution {
    public int maxScore(String s) {
        int oCnt = 0;
        for(int  i=0;i<s.length();i++) {
            if(s.charAt(i)=='1') {
                oCnt++;   
            }
        }
        
        int ans = 0;
        int zCnt =0;
        
        for(int i=0;i<s.length()-1;i++) 
        {
            char ch = s.charAt(i);
            if(ch=='1') {
                oCnt--;
              
            }           
            else {
                 zCnt++;
            }
            ans = Math.max(ans, zCnt + oCnt);
        }
        
        return ans;
    }
}