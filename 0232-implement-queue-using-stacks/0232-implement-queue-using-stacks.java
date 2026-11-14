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
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        s1.push(x);
    }
    
    public int pop() {
        // get the data in s2
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        if(s2.isEmpty()) return -1;
        else{
            size--;
            return s2.pop();
        }
    }
    
    public int peek() {
        // get the data back in s2
        while(!s1.isEmpty()){
            s2.push(s1.pop());
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