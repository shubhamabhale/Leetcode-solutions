class Solution {
    int mincount = Integer.MAX_VALUE;
    int cnt =0;
    public void recurse(String str) {
        if(str.length()==1) {
            cnt++;
            return;
        }
        if(str.length()==2){
            if(str.equals("01") || str.equals("10")) {
                cnt++;
            }
            return;
        }
        int i = 0;
        while(i<str.length()) {
            String temp = str.substring(i, i+2);
            recurse(temp);
            i += 2;
        }
     }
    public int minChanges(String s) {
            
        recurse(s);
        return cnt;
    }
}