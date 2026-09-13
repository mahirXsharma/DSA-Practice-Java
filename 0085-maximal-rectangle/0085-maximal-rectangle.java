class Solution {
    public int maximalRectangle(char[][] matrix) {
        int heights[] = new int[matrix[0].length];
        int ans = 0;
        for(char row[] : matrix){
            for(int i=0; i<matrix[0].length; i++){
                heights[i] += row[i] - '0';
                if(row[i]-'0' == 0) heights[i] = 0;
            }
            int curr = help(heights);
            ans = Math.max(curr, ans);
        }
        return ans;
    }

    public int help(int[] heights) {
        int n = heights.length;
        int right[] = new int[n];
        int left[] = new int[n];

        Deque<Integer> s = new ArrayDeque<>();
        for(int i=n-1; i>=0; i--){
            int curr = heights[i];
            while(!s.isEmpty() && heights[s.peek()] >= curr){
                s.pop();
            }
            if(s.isEmpty()) right[i] = n;
            else right[i] = s.peek();
            s.push(i);
        }
        s.clear();
        for(int i=0; i<n; i++){
            int curr = heights[i];
            while(!s.isEmpty() && heights[s.peek()] >= curr){
                s.pop();
            }
            if(s.isEmpty()) left[i] = -1;
            else left[i] = s.peek();
            s.push(i);
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            int rightChoices = right[i] - i;
            int leftChoices = i - left[i] -1;
            int totalChoices = rightChoices + leftChoices ;
            ans = Math.max(ans, totalChoices * heights[i]);
        }
        return ans;
    }
}