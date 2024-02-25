class Solution {
    public boolean checkValidString(String s) {
        int left =0;
        for(char ch: s.toCharArray()){
            if(ch=='(' || ch=='*')
                left++;
            else 
                left--;
            if(left<0)
                return false;
        }
        
        int right =0;
        char[] chr = s.toCharArray();
        
        for(int i=chr.length-1;i>=0;i--){
            if(chr[i]==')' || chr[i]=='*')
                right++;
            else 
                right--;
            if(right<0)
                return false;
        }
        
        return true;
    }
}