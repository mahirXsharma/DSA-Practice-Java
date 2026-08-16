class Solution {
    int[] tin ;
    int[] low;
    int gc= 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        tin = new int[n];
        low = new int[n];
        boolean vis[] = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        for(int i=0; i<n; i++) {
            arr.add(new ArrayList<>());
            }
        for(List<Integer> curr : connections){
            arr.get(curr.get(0)).add(curr.get(1));
            arr.get(curr.get(1)).add(curr.get(0));
        }
        dfs(0, -1, arr, ans, vis);
        return ans;
    }
    
    public int dfs(int curr, int par, List<List<Integer>> arr, List<List<Integer>> ans, boolean vis[]){
        low[curr] = gc;
        tin[curr] = gc;
        gc++;
        vis[curr] = true;
        for(int bro : arr.get(curr)){
            if(bro == par) continue;
            else if(vis[bro] != true){
                int newLow = dfs(bro, curr, arr, ans, vis);
                low[curr] = Math.min(low[curr], newLow);
                if(newLow > tin[curr]){
                    // found a bridge
                    ans.add(new ArrayList<>(List.of(curr, bro)));
                }
            }
            else{
                low[curr] = Math.min(low[curr], tin[bro]);
            }
        }
        return low[curr];
    }

}