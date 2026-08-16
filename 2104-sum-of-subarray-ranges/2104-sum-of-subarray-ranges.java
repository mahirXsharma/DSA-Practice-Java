class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        Deque<Integer> s = new ArrayDeque<>();
        
        // 1. Find Left Boundaries for Minimums
        Arrays.fill(leftMin, -1);
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && nums[s.peek()] >= nums[i]) s.pop();
            if(!s.isEmpty()) leftMin[i] = s.peek();
            s.push(i);
        }
        
        // 2. Find Right Boundaries for Minimums
        s.clear();
        Arrays.fill(rightMin, n);
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && nums[s.peek()] >= nums[i]) rightMin[s.pop()] = i;
            s.push(i);
        }
        
        // 3. Find Left Boundaries for Maximums
        s.clear();
        Arrays.fill(leftMax, -1);
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && nums[s.peek()] <= nums[i]) s.pop();
            if(!s.isEmpty()) leftMax[i] = s.peek();
            s.push(i);
        }
        
        // 4. Find Right Boundaries for Maximums
        s.clear();
        Arrays.fill(rightMax, n);
        for(int i = 0; i < n; i++) {
            while(!s.isEmpty() && nums[s.peek()] <= nums[i]) rightMax[s.pop()] = i;
            s.push(i);
        }
        
        // 5. Calculate Final Math using the Index Spans
        long sum = 0;
        for(int i = 0; i < n; i++) {
            // (long) cast prevents massive index multiplication from overflowing
            long minSpan = (long)(i - leftMin[i]) * (rightMin[i] - i);
            long maxSpan = (long)(i - leftMax[i]) * (rightMax[i] - i);
            
            // Add the max contribution, subtract the min contribution
            sum += (maxSpan - minSpan) * nums[i];
        }
        
        return sum;
    }
}