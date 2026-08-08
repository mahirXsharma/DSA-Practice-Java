class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> s = new ArrayDeque<>();
        int ans[] = new int[n];
        s.push(n-1);
        ans[n-1] = 0;

        for(int i=n-2; i>= 0; i--){
            int curr = temperatures[i];
            while(!s.isEmpty() && temperatures[s.peek()] <= curr){
                s.pop();
            }
            if(s.isEmpty()) ans[i] = 0;
            else ans[i] = s.peek() - i;
            s.push(i);
        }
        return ans;
    }
}