class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int parent[] = new int[n];
        int ans = n;

        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for(int j=i+1; j<n; j++){
                int curr = isConnected[i][j];
                if(curr == 1 ){
                    boolean didMerge = union(i, j, parent);
                    if(didMerge) ans--;
                }
            }
        }
        return ans;
    }
    
    public boolean union(int x, int y, int parent[]){
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if(rootX == rootY) return false;
        parent[rootX] = rootY;
        return true;
    }

    public int find(int parent[], int node){
        int father = parent[node];
        if(father == node) return father;
        int ans = find(parent, father);
        parent[node] = ans;
        return ans;
    }
}