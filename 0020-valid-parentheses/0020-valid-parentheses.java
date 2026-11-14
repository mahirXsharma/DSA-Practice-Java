class Solution {
    public boolean isValid(String s) {
        // n-> 10^4 => So N only
        // if its oopen-> push it || close -> pop and check
        int n = s.length();
        if(n % 2 == 1) return false;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                char curr = stack.pop();
                if( ch == ')' && curr != '('  ||
                    ch == ']' && curr != '['  ||
                    ch == '}' && curr != '{' 
                ){
                    return false;
                }
            }
        }
        return stack.isEmpty() ;
    }
}