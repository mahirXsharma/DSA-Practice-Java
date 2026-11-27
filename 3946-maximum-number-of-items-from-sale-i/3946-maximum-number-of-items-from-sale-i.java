class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int freeCopies[] = new int[n];
        int dp[][][] = new int[n][budget+1][2];

        for(int row[][] : dp){
            for(int deepRow[] : row){
                Arrays.fill(deepRow, -1);
            }
        }
        // TC -> N^2
        for(int i=0; i<n; i++){
            int icurr[] = items[i];
            int count = 0;
            for(int j=0; j<n; j++){
                if(i != j){
                    int jcurr[] = items[j];
                    if(jcurr[0]%icurr[0] == 0) count++;
                }
            }
            freeCopies[i] = count;
        }

        // recursion <-> backtracking -> 2^N
        return dfs(items, budget, 0, freeCopies, n, dp, 0);
    }

    public int dfs(int items[][], int k, int i, int free[], int n, int dp[][][], int taken){
        if(k == 0 || i == n) return 0;
        if(dp[i][k][taken] != -1) return dp[i][k][taken];
        // take or leave
        int curr[] = items[i], take = 0, leave = 0;
        if(k - curr[1] >= 0){
            int bonus = (taken == 0) ? free[i] : 0;
            take = dfs(items, k-curr[1], i, free, n, dp, 1) + 1 + bonus;
        }
        leave = dfs(items, k, i+1, free, n, dp, 0);
        return dp[i][k][taken] = Math.max(take, leave);
    }
}