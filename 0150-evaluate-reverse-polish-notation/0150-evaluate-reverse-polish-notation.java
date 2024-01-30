class Solution {
    public boolean isNumeric(String token) {
        try {
        Double.parseDouble(token);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens)
        {
            if(isNumeric(token))
            {
                stack.push(Integer.parseInt(token));
            }
            else{
                if(stack.isEmpty())
                {
                    return 0;
                }
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(token) {
                    case "*":
                        stack.push(num1*num2);
                        break;
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num2-num1);
                        break;
                    case "/":
                        stack.push(num2/num1);
                        break;
                }
            }
        }

        return stack.peek();
    }
}