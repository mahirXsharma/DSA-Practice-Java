class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int arr[] = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                q.add(i);
                arr[i] = -1;
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    int[] bros = graph[curr];
                    for (int bro : bros) {
                        if(arr[bro] == arr[curr]) return false;
                        if(arr[bro]==0) {
                            arr[bro] = -arr[curr];
                            q.add(bro);
                        }
                    }
                }
            }
        }

        return true;
    }
}