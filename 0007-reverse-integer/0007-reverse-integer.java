class Solution {
    public int reverse(int x) {
        boolean signed = false;
        if(x<0){
            signed = true;
            x = -1*x;
        }
        
        int carry = 1;
        int ans=0;
        String temp = String.valueOf(x);
        int n = temp.length()-1;
        while(x>0){
            
            carry = x%10;
            ans += carry*(Math.pow(10,n));
            n--;
            x=x/10;
            if(ans>=Integer.MAX_VALUE)
                return 0;
        }
        
        return signed?-1*ans:ans;
            
    }
}