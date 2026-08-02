class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (dst == src)
            return 0;
        ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int curr[] : flights) {
            arr.get(curr[0]).add(new int[] { curr[1], curr[2] });
        }
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, src, 0 }); // {current_stops, current_Node, current_cost}

        while (!q.isEmpty()) {
            int curr[] = q.poll();
            int currentStops = curr[0];
            int currentNode = curr[1];
            int currentCost = curr[2];

            // Bouncer 1: Did we exceed our allowed stops?
            if (currentStops > k)
                continue;

            for (int bro[] : arr.get(currentNode)) {
                int neighborNode = bro[0];
                int priceToNeighbor = bro[1];

                int newCost = currentCost + priceToNeighbor;

                // Bouncer 2: Is this new route cheaper than our previous record for this city?
                if (newCost < dist[neighborNode]) {
                    dist[neighborNode] = newCost; // Update the record book!
                    q.add(new int[] { currentStops + 1, neighborNode, newCost });
                }
            }
        }

        // After the queue is completely empty, the dist array holds our absolute lowest prices.
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}