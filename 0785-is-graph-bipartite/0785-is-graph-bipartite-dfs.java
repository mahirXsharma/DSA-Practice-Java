class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
                if (dfs(graph, arr, i) == false)
                    return false;
            }
        }
        return true;
    }

    public boolean dfs(int graph[][], int arr[], int curr) {
        for(int bro : graph[curr]){
            if(arr[bro] == 0){
                arr[bro] = -arr[curr];
                if( dfs(graph, arr, bro) == false) return false;
            }
            else if(arr[bro] == arr[curr]) return false;
        }
        return true;
    }
}