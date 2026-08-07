class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // In this question, it is guaranteed, that there will be -ve edge 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int dist[][] = new int[n][n];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            arr.get(edge[0]).add(new int[]{edge[1], edge[2]});
            arr.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        for(int i=0; i<n; i++){
            pq.add(new int[]{i, 0});
            // dist[i][i] IS ZERO !
            dist[i][i] = 0;
            while(!pq.isEmpty()){
                int curr[] = pq.poll();
                int currNode = curr[0],  currCost = curr[1];
                for(int bro[] : arr.get(currNode)){
                    int nextNode = bro[0], nextCost = bro[1] + currCost;
                    if(nextCost < dist[i][nextNode]){
                        dist[i][nextNode] = nextCost;
                        pq.add(new int[]{nextNode, nextCost});
                    }
                } 
            }
        } 
         int prev = 101, currNode = -1;
        for(int i=0; i<n; i++){
            int ans = 0;
            for(int j=0; j<n; j++){
                if(dist[i][j] <= distanceThreshold) ans ++;
            }
            if(ans <= prev){
                prev = ans;
                currNode = i;
            }
        }
        return currNode;
    }  
}