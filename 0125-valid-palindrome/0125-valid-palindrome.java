class Solution {
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        String lower = s.toLowerCase();
        while(i<j){
            char left = lower.charAt(i);
            char right = lower.charAt(j);
            if(!Character.isLetterOrDigit(left)){
                i++;
                continue;
            }
            if( !Character.isLetterOrDigit(right) ){
                j--;
                continue;
            }
            if(left != right) return false;
            i++;
            j--;
        }
        return true;
    }
}