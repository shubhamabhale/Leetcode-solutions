class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> pque;
    public MinStack() {
        stack = new Stack<>();
        pque = new PriorityQueue<>();
        
    }
    
    public void push(int val) {
        stack.push(val);
        pque.add(val);
    }
    
    public void pop() {
        if(!stack.isEmpty())
        {
            int temp = stack.pop();
            pque.remove(temp);
        }
    }
    
    
    public int top() {
        return stack.peek();   
    }
    
    public int getMin() {
        return pque.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */