class Solution {
    public int minCost(int n, int[] cuts) {
        int size = cuts.length;
        int arr[] = new int[size + 2];
        arr[0] = 0;
        arr[arr.length-1] = n;
        for(int i=0; i<size; i++){
            arr[i+1] = cuts[i];
        }
        Arrays.sort(arr);
        int idx = arr.length;
        int dp[][] = new int[idx][idx];
        for(int row[] : dp) Arrays.fill(row, -1);
        return dfs(0, idx-1, arr, dp);
    }

    public int dfs(int i, int j, int arr[], int dp[][]){
        if(j-i <= 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;

        for(int k=i+1; k<j; k++){
            // make cut at k
            int cost = dfs(i, k, arr, dp) + dfs(k, j, arr, dp) + arr[j]-arr[i];
            if(cost < ans) ans = cost;
        }
        return dp[i][j] = ans;
    }
}