class Solution {
    public int hammingWeight(int n) {
        // n-> 2^31 ?? what?
        // i know there is a solution which runs O(K) where K is the total number of set bits
        int count = 0;
        while(n != 0){
            int mask = n & 1;
            if(mask == 1) count++;
            n = n >>> 1;
        }
        return count;

    }
}