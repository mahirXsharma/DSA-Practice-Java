class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n + 2];
        int dp[][] = new int[n+2][n+2];
        for(int row[] : dp) Arrays.fill(row, -1);
        for(int i=0; i<n; i++)arr[i+1] = nums[i];
        arr[0]=1;
        arr[arr.length-1] = 1;
        return dfs(1, n, arr, dp);
    }

    public int dfs(int i, int j, int arr[], int dp[][]){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MIN_VALUE;
        for(int k=i; k<= j; k++){
            // taking k to be the last guy
            int cc = arr[k] * arr[i-1] * arr[j+1] + dfs(i, k-1, arr, dp) + dfs(k+1, j, arr, dp);
            ans = Math.max(ans, cc);
        }
        return dp[i][j] = ans;
    }
}