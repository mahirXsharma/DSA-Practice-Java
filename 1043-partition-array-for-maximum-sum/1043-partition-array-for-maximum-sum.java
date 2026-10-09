class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n+k];
        // Arrays.fill(dp, -1);
        // return dfs(0, k, arr, n, dp);

        for(int i=n-1; i>=0; i--){
            
            int ans = Integer.MIN_VALUE;
            int max = arr[i];
            for(int p=1; p<=k; p++){
                if(i+p > n) continue;
                int idx = i+p-1;
                if(arr[idx] > max) max = arr[idx];
                int cost = p*max + dp[i+p];
                ans = Math.max(ans, cost);
            }
             dp[i] = ans;
        }
        return dp[0];
    }

    public int dfs(int i, int k, int arr[], int n, int dp[]){
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        int ans = Integer.MIN_VALUE;
        int max = arr[i];
        for(int p=1; p<=k; p++){
            if(i+p > n) continue;
            int idx = i+p-1;
            if(arr[idx] > max) max = arr[idx];
            int cost = p*max + dfs(i+p, k, arr, n, dp);
            ans = Math.max(ans, cost);
        }
        return dp[i] = ans;
    }

    // public int subarr(int i, int j, int arr[]){
    //     int len = j-i;
    //     int max=Integer.MIN_VALUE;
    //     for(int idx = i; idx <j; idx++){
    //         max = Math.max(max, arr[idx]);
    //     }
    //     return max * len;
    // }

    // purpose of this funciton -> subarr -> it calc max, i to i+p-1 -> we need
    // max of this range. 
}