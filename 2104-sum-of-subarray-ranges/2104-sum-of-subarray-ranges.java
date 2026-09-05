class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        Deque<Integer> s = new ArrayDeque<>();
        // right Max
        for(int i=n-1; i>= 0; i--){
            int curr = nums[i];
            while(!s.isEmpty() && curr >= nums[s.peek()]){
                s.pop();
            }
            rightMax[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        // right Min
        s.clear();
        for(int i=n-1; i>= 0; i--){
            int curr = nums[i];
            while(!s.isEmpty() && curr <= nums[s.peek()]){
                s.pop();
            }
            rightMin[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        // leftMax
        s.clear();
        for(int i=0; i<n; i++){
            int curr = nums[i];
            while(!s.isEmpty() && curr > nums[s.peek()]){
                s.pop();
            }
            leftMax[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        s.clear();
        // left Min
        for(int i=0; i<n; i++){
            int curr = nums[i];
            while(!s.isEmpty() && curr < nums[s.peek()]){
                s.pop();
            }
            leftMin[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        long totalMax = 0;
        long totalMin = 0;
        for(int i=0; i<n; i++){
            // max choices
            long rightMaxchoice = rightMax[i] - i;
            long leftMaxchoice = i - leftMax[i];
            long totalmaxchoices = rightMaxchoice * leftMaxchoice;
            totalMax += totalmaxchoices * nums[i];

            // min choices
            long leftMinchoice = i - leftMin[i];
            long rightMinchoice = rightMin[i] - i;
            long totalMinchoices = leftMinchoice * rightMinchoice;
            totalMin += totalMinchoices * nums[i];
            
        }

        return totalMax - totalMin;

        
        
    }
}