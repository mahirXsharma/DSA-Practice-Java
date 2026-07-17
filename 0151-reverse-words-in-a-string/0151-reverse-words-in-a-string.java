class Solution {
    public String reverseWords(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder("");
        for(char ch : s.toCharArray()){
            if(stack.isEmpty() && ch == ' ') continue;
            if(ch == ' ' && stack.peek() == ' ') continue;
            stack.push(ch);
        }
        while(!stack.isEmpty()){
            if(stack.peek() == ' ' && sb.isEmpty()){
                stack.pop();
                continue;
            }
            sb.append(stack.pop());
        }
        String arr[] = sb.toString().split(" ");
        for(int i=0; i<arr.length; i++){
            arr[i] = new StringBuilder(arr[i]).reverse().toString();
        }
        String ans = String.join(" ", arr);
        return ans;
    }
}