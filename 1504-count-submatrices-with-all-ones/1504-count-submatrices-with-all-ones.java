class Solution {
    public int numSubmat(int[][] mat) {

        int n=mat.length, m = mat[0].length; 
        int arr[] = new int[m];

        int ans = 0;

        for(int row[] : mat){
            for(int i=0; i<m; i++){
                if(row[i] == 0) arr[i] = 0;
                else arr[i] += row[i];

            }
            // built the arr for this row
            ans += helper(arr);
        }
        return ans;
        // int dp[][] = new int[n][m];

        // for(int i=0; i<n; i++)dp[i][0] = mat[i][0];
        // // clone mat
        // for(int i=0; i<n; i++){
        //     for(int j=1; j<m; j++){
        //         if(mat[i][j] == 0) continue;
        //         dp[i][j] = dp[i][j-1] +1;
        //     }
        // }
        // int ans = 0;
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         int row = i;
        //         int curr = dp[row][j];
        //         if(curr == 0) continue;
        //         int min = curr;
        //         while(min > 0 && row >= 0){
        //             min = Math.min(min, dp[row][j]);
        //             ans += min;
        //             row--;
        //         }
        //     }
        // }
        // return ans;
    }

    public int helper(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int[] sum = new int[n];  // sum[i] = number of rectangles ending at i

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                sum[i] = arr[i] * (i + 1);
            } else {
                sum[i] = sum[st.peek()] + arr[i] * (i - st.peek());
            }

            st.push(i);
            ans += sum[i];
        }
        return ans;
    }
}