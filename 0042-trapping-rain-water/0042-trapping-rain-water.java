class Solution {
    public int trap(int[] height) {
        // The Optimal 2 Pointer Approach
        int n = height.length;
        int left = 0, right = n-1;
        int leftMax = height[left], rightMax = height[right];
        int ans = 0;
        while(left <= right){
            if(leftMax <= rightMax){
                leftMax = Math.max(leftMax, height[left]);
                int h = leftMax - height[left];
                ans += h;
                left++;
            }
            else {
                rightMax = Math.max(rightMax, height[right]);
                int h = rightMax - height[right];
                ans += h;
                right--;
            }
        }

        return ans;

        // // Calculating the ans Horizontally
        // int n = height.length;
        // Deque<Integer> s = new ArrayDeque<>();
        // int ans = 0;
        // for(int i=0; i<height.length; i++){
        //     while(!s.isEmpty() && height[i] > height[s.peek()]){
        //         // found the right wall
        //         int bottom = height[s.pop()];
        //         if(s.isEmpty()){
        //             break;
        //         }
        //         int leftWall = height[s.peek()];
        //         int h = Math.min(leftWall, height[i]) - bottom;
        //         int width = i - s.peek() - 1;
        //         int currArea = h * width;
        //         ans += currArea;
        //     }
            
        //     s.push(i);
        // }
        // return ans;



        // // Calcualting the ans Vertically
        // int n = height.length;
        // int left[] = new int[n];
        // int right[] = new int[n];
        // left[0] = height[0];
        // for(int i=1; i<n; i++){
        //     left[i] = Math.max(left[i-1], height[i]);
        // }
        // right[n-1] = height[n-1];
        // for(int i=n-2; i>=0; i--){
        //     right[i] = Math.max(right[i+1], height[i]);
        // }

        // int ans = 0;
        // for(int i=0; i<n; i++){
        //     int lb = left[i];
        //     int rb = right[i];
        //     int Height = Math.min(lb, rb) - height[i];
        //     ans += Height;
        // }
        // return ans;
    }
}