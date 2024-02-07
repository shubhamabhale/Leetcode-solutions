class Solution {
    public int[] sumZero(int n) {
        
        int[] answer = new int[n];
        
        for(int i=1, j=n-1;j>=i;i++,j--) {
            answer[i-1] = -i;
            answer[j] = i;
        }
        if(n%2==1)
            answer[n/2] = 0;
        
        return answer;
    }
}