class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        // The Deque will store indices, not the actual numbers
        Deque<Integer> q = new ArrayDeque<>();
        
        int ansIndex = 0; 
        
        for (int i = 0; i < n; i++) {
            // 1. Remove out-of-bounds elements from the FRONT
            if (!q.isEmpty() && q.peekFirst() == i - k) {
                q.pollFirst();
            }
            
            // 2. Remove smaller elements from the BACK
            // (They are useless because a bigger number just arrived)
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            
            // 3. ALWAYS add the current element's index to the BACK
            q.offerLast(i);
            
            // 4. Once the window hits size 'k', the biggest number is always at the FRONT
            if (i >= k - 1) {
                ans[ansIndex++] = nums[q.peekFirst()];
            }
        }
        
        return ans;
    }
}