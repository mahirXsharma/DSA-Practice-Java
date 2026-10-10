class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> s = new ArrayDeque<>();
        int n = expression.length();
        for(int i=0; i<n; i++){
            char curr = expression.charAt(i);
            if(curr == ',') continue;
            else if(curr == ')'){
                boolean onef = false, onet = false;
                boolean exp = true;
                while(s.peek() != '('){
                    char check = s.peek();
                    if(check == 't') onet = true;
                    else onef = true;
                    s.pop();
                }
                s.pop();// pop the (
                // find the operator
                char opr = s.pop();
                if (opr == '&') {
                    exp = !onef; 
                } else if (opr == '|') {
                    exp = onet;
                } else if (opr == '!') {
                    exp = !onet;
                }
                char charpush = exp == true ? 't' : 'f';
                s.push(charpush);
            }
            else s.push(curr);
        }
        return s.peek() == 't' ? true : false;
    }

}