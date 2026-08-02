class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int curr[] : times) {
            arr.get(curr[0]).add(new int[] { curr[1], curr[2] });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { k, 0 });
        boolean vis[] = new boolean[n + 1];
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0], currCost = curr[1];
            if (vis[currNode])
                continue;
            vis[currNode] = true;
            ans = currCost;

            for (int bro[] : arr.get(currNode)) {
                if (!vis[bro[0]]) {
                    pq.add(new int[] { bro[0], bro[1] + currCost });
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            if (!vis[i])
                return -1;
        }
        return ans;
    }
}