class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        // Always binary search the smaller array to prevent out-of-bounds errors
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int low = 0, high = n1;
        // The total number of elements that MUST be in our Left Pile
        int leftLength = (n1 + n2 + 1) / 2; 
        int n = n1 + n2;
        
        while (low <= high) {
            int mid1 = low + (high - low) / 2; // Cards taken from Deck 1
            int mid2 = leftLength - mid1;      // Cards forced to take from Deck 2
            
            // Calculate the 4 boundary cards
            // If we take 0 cards from a side, treat the boundary as -Infinity or +Infinity
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];
            
            // The Cross-Check: Is this the perfect cut?
            if (l1 <= r2 && l2 <= r1) {
                // If total cards are odd, the median is just the biggest card in the Left Pile
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                } 
                // If even, it's the average of the biggest on the left and smallest on the right
                else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }
            
            // If the card from Deck 1 is too big, we took too many cards from Deck 1. Slide left.
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            // Otherwise, we didn't take enough cards from Deck 1. Slide right.
            else {
                low = mid1 + 1;
            }
        }
        
        return 0.0;
    }
}