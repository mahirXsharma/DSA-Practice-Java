
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixSet = new HashSet<>();
        int maxLength = 0;

        // 1. Shatter arr1 into all possible prefixes and save them
        for (int num : arr1) {
            while (num > 0) {
                prefixSet.add(num);
                num /= 10; // Chops off the last digit: 1234 -> 123 -> 12 -> 1
            }
        }

        // 2. Interrogate arr2 against our prefix vault
        for (int num : arr2) {
            while (num > 0) {
                // If we find a match, check its length
                if (prefixSet.contains(num)) {
                    int currentLength = String.valueOf(num).length();
                    maxLength = Math.max(maxLength, currentLength);
                    
                    // Optimization: Since we are checking from longest to shortest prefix 
                    // for this specific number, the first match we hit is the longest one!
                    break; 
                }
                num /= 10;
            }
        }

        return maxLength;
    }
}