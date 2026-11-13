class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            char curr = s.charAt(i);
            if(Character.isLetterOrDigit(curr)){
                sb.append(Character.toLowerCase(curr));
            }
        }
        // its a perfectString
        String str = sb.toString();
        return aPalindrome(str);
    }

    public boolean aPalindrome(String s){
        int n = s.length();
        int left = 0, right = n-1;
        while( left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}