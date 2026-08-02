class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int[] curr : times) {
            arr.get(curr[0]).add(new int[]{curr[1], curr[2]});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{ k, 0 });

        // 4. Pure Dijkstra
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currCost = curr[1];

            if (currCost > dist[currNode]) continue;

            for (int[] bro : arr.get(currNode)) {
                int nextNode = bro[0];
                int nextTime = currCost + bro[1];

                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    pq.add(new int[]{ nextNode, nextTime });
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; 
            }
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}