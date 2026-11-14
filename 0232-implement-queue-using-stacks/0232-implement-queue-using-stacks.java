class MyQueue {
    // the TC of all the operations should O(1)
    ArrayDeque<Integer> s1 ;
    ArrayDeque<Integer> s2;
    int size;

    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
        size = 0;   
    }
    
    public void push(int x) {
        size++;
        // get back the data in s1

        s1.push(x);
    }
    
    public int pop() {
        // get the data in s2
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        if(s2.isEmpty()) return -1;
        else {
            int val = s2.pop();
            size--;
            return val;
        }
    }
    
    public int peek() {
        // get the data back in s2
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.isEmpty() ? -1 : s2.peek();
    }
    
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */