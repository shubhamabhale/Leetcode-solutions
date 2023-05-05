class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        if(temperatures.length==0)
            return null;
        int[] ans = new int[temperatures.length];
        int i=0;
        while(i<temperatures.length)
        {
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i])
            {
                int temp = stack.pop();
                ans[temp] = i-temp;
            }
            stack.push(i);
            i++;
        }
        ans[ans.length-1]=0;
        return ans;
    }
}