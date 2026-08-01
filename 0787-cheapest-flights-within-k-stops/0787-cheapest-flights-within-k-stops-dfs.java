class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
        int memo[][] = new int[n][k+2];
        for(int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for(int i=0; i<n; i++){
            arr.add(new ArrayList<>());
        }
        for(int curr[] : flights){
            arr.get(curr[0]).add(new int[]{curr[1], curr[2]});
        }
        int ans = 0, minCost = Integer.MAX_VALUE;
        return dfs(arr, k, ans, src, dst, minCost, memo);
    }
    public int dfs(ArrayList<ArrayList<int[]>> arr, int k, int ans, int src, int dst, int minCost, int memo[][]){
        if(k < 0) return -1;
        if (ans >= memo[src][k + 1]) {
            return -1; 
        }
        memo[src][k+1] = ans;
        for(int[] curr : arr.get(src)){
            if(curr[0] == dst){
                minCost = Math.min(ans + curr[1], minCost);
                continue;
            }
            int result = dfs(arr, k-1, ans + curr[1], curr[0], dst, minCost, memo);
            if(result != -1){
                minCost = Math.min(result, minCost);
            }
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}