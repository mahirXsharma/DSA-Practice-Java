class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int ans[][] = new int[n][n];
        for(int[] row : ans){
            Arrays.fill(row, -1);
        }
        // filling the right diagonal with 0's
        for(int i=0; i<n; i++){
            ans[i][i] = 0;
        }

        for(int edge[] : edges){
            int curr = edge[0], nextNode = edge[1], dist = edge[2];
            ans[curr][nextNode] = dist;
            ans[nextNode][curr] = dist;
        }

        // floyd warshall 
        for(int via = 0; via < n; via++){
            for(int i=0; i<n; i++){
                if(ans[i][via] == -1) continue;
                for(int j=0; j<n; j++){
                    if(ans[via][j] != -1){
                        int newDist = ans[i][via] + ans[via][j];
                        if(ans[i][j] == -1 || newDist < ans[i][j]) ans[i][j] = newDist;
                    }
                }
            }
        }
        int currNode = -1, prevCount =101;

        for(int i=0; i<n; i++){   
            int currCount = 0;         
            for(int j=0; j<n; j++){
                int curr = ans[i][j];
                if(curr != -1 && curr!= 0 && curr <= distanceThreshold){
                    currCount++;
                }
            }
            if(currCount <= prevCount){
                currNode = i;
                prevCount = currCount;
            }
        }
        return currNode;
    }
}