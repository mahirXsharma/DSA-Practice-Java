class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build the Adjacency List (1-indexed, so size n + 1)
        ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int[] curr : times) {
            arr.get(curr[0]).add(new int[]{curr[1], curr[2]});
        }

        // 2. The Bouncer: track the absolute fastest times to each node
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // Starting node takes 0 time

        // 3. Priority Queue: [node, current_cost] sorted by lowest cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{ k, 0 });

        // 4. Pure Dijkstra
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currCost = curr[1];

            // If we popped a stale, slower path from the queue, ignore it!
            if (currCost > dist[currNode]) continue;

            for (int[] bro : arr.get(currNode)) {
                int nextNode = bro[0];
                int nextTime = currCost + bro[1];

                // The Pre-Bouncer: ONLY add to PQ if we found a strictly faster route
                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    pq.add(new int[]{ nextNode, nextTime });
                }
            }
        }

        // 5. Find the final answer
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            // If any node is still at MAX_VALUE, the signal never reached it
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; 
            }
            // The network delay is the maximum time it took to reach the furthest node
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}