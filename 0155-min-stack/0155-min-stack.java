class MinStack {
   Deque<int[]> s = new ArrayDeque<>();
    public MinStack() {
        
    }
    
    public void push(int value) {
        if(s.isEmpty()) s.push(new int[] {value, value});
        else {
            s.push(new int[]{value, Math.min(value, s.peek()[1])});
        }

    }
    
    public void pop() {
        if(!s.isEmpty())  s.pop();
    }
    
    public int top() {
        if(!s.isEmpty()) return s.peek()[0];
        return -1;
    }
    
    public int getMin() {
        if(!s.isEmpty()) return s.peek()[1];
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */