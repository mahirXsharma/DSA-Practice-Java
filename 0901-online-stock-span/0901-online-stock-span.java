class StockSpanner {
    Deque<int[]> s; 
    public StockSpanner() {
        s = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int curr[] = new int[]{price, 1};
        while(!s.isEmpty() && s.peek()[0] <= curr[0]){
            curr[1] += s.pop()[1];
        }
        s.push(curr);
        return s.peek()[1];
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */