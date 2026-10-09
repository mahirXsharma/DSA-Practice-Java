class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return dfs(0, k, arr, n, dp);
    }

    public int dfs(int i, int k, int arr[], int n, int dp[]){
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        int ans = Integer.MIN_VALUE;
        for(int p=1; p<=k; p++){
            if(i+p > n) continue;
            int cost = subarr(i, i+p, arr) + dfs(i+p, k, arr, n, dp);
            ans = Math.max(ans, cost);
        }
        return dp[i] = ans;
    }

    public int subarr(int i, int j, int arr[]){
        int len = j-i;
        int max=Integer.MIN_VALUE;
        for(int idx = i; idx <j; idx++){
            max = Math.max(max, arr[idx]);
        }
        return max * len;
    }
}