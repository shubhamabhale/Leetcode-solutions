class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        if(asteroids.length==1)
            return asteroids;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int x: asteroids)
        {
            if(x>0)
            {
                stack.push(x);
            }
            else
            {
                while(!stack.isEmpty() && Math.abs(x)>stack.peek() && stack.peek()>0)
                {
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek()<0)
                {
                    stack.push(x);
                }
                else if(x+ stack.peek()==0)
                {
                    stack.pop();
                }
            }
        }
        
        int[] ans = new int[stack.size()];
        for(int i=ans.length-1;i>=0;i--)
        {
            ans[i]=stack.pop();
        }
        return ans;
    }
}