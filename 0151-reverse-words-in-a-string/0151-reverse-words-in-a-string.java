class Solution {
    public String reverseWords(String s) {
        // 1. Trim outer spaces, then split by ONE OR MORE spaces
        String[] words = s.trim().split("\\s+");
        
        // 2. Build the new string backwards
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" "); // Add a single space between words
            }
        }
        
        return sb.toString();
    }
}