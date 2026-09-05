class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k == n) return "0";
        if(k == 0) return num;
        Deque<Integer> s = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            char curr = num.charAt(i);
            while(!s.isEmpty() && curr < num.charAt(s.peek()) && k > 0){
                s.pop();
                k--;
            }
            s.push(i);
        }
        if(s.isEmpty()) return "0";

        while (k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(num.charAt(s.pop()));
        }
        String str = sb.reverse().toString();
        int start = 0;
        while(start < str.length() && str.charAt(start) == '0')start++;
        return start == str.length() ? "0" : str.substring(start);
    }
}