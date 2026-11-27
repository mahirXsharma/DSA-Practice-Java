class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int freeCopies[] = new int[n];
        int dp[][][] = new int[2][n][budget + 1];

        for (int row[][] : dp) {
            for (int deepRow[] : row) {
                Arrays.fill(deepRow, -1);
            }
        }
        // 1. Find max factor and build frequency array
        int maxF = 0;
        for (int i = 0; i < n; i++) {
            maxF = Math.max(maxF, items[i][0]);
        }
        int[] freq = new int[maxF + 1];
        for (int i = 0; i < n; i++) {
            freq[items[i][0]]++;
        }

        // 2. For each factor x, jump ONLY through its multiples (x, 2x, 3x...)
        int[] multCount = new int[maxF + 1];
        for (int x = 1; x <= maxF; x++) {
            if (freq[x] == 0)
                continue; // nobody has factor x, skip it
            for (int mult = x; mult <= maxF; mult += x) {
                multCount[x] += freq[mult];
            }
        }

        // 3. Fill freeCopies (subtract 1 to exclude the item itself)
        for (int i = 0; i < n; i++) {
            freeCopies[i] = multCount[items[i][0]] - 1;
        }

        // recursion <-> backtracking -> 2^N
        return dfs(items, budget, 0, freeCopies, n, dp, 0);
    }

    public int dfs(int items[][], int k, int i, int free[], int n, int dp[][][], int taken) {
        if (k == 0 || i == n)
            return 0;
        if (dp[taken][i][k] != -1)
            return dp[taken][i][k];
        // take or leave
        int curr[] = items[i], take = 0, leave = 0;
        if (k - curr[1] >= 0) {
            int bonus = (taken == 0) ? free[i] : 0;
            take = dfs(items, k - curr[1], i, free, n, dp, 1) + 1 + bonus;
        }
        leave = dfs(items, k, i + 1, free, n, dp, 0);
        return dp[taken][i][k] = Math.max(take, leave);
    }
}