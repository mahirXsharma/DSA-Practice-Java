class Solution {
    public int countPaths(int n, int[][] roads) {
        // 1. Build the Adjacency List (Bi-directional graph!)
        ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            arr.get(road[0]).add(new int[]{road[1], road[2]});
            arr.get(road[1]).add(new int[]{road[0], road[2]});
        }

        // 2. The Setup: Big numbers require long[]
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        dist[0] = 0; // 0 minutes to start
        ways[0] = 1; // 1 way to be at the starting line
        
        int MOD = 1000000007;

        // 3. Priority Queue: [currentNode, currentTime]
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0, 0});

        // 4. Pure Dijkstra
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int currNode = (int) curr[0];
            long currTime = curr[1];

            // Bouncer: Ignore dead/slower paths that got stuck in the queue
            if (currTime > dist[currNode]) continue;

            for (int[] bro : arr.get(currNode)) {
                int nextNode = bro[0];
                long travelTime = bro[1];
                long newTime = currTime + travelTime;

                // SCENARIO A: Smashed the record!
                if (newTime < dist[nextNode]) {
                    dist[nextNode] = newTime;        // Lock in new fast time
                    ways[nextNode] = ways[currNode]; // Reset tally counter to match the new route
                    pq.add(new long[]{nextNode, newTime});
                } 
                // SCENARIO B: Tied the record exactly!
                else if (newTime == dist[nextNode]) {
                    // Just add the ways together, apply the MOD to prevent memory overflow!
                    ways[nextNode] = (ways[nextNode] + ways[currNode]) % MOD;
                }
            }
        }

        // Return the final tally counter for the destination node
        return (int) ways[n - 1];
    }
}