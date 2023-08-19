class Solution {
    public int numberOfSteps(int num) {
        if(num==0 || num==1)
            return num;
        int ans=0;
        while(num>0)
        {
            if(num%2==0)
            {
                ans++;
                num = num/2;
            }
            else
            {
                ans++;
                num--;
            }
        }
        return ans;
    }
}