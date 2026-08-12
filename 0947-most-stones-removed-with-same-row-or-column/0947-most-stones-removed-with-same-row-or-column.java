class Disjoint{
    int[] parent;
    int[] size;
    public Disjoint(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findPar(int u){
        if ( u == parent[u]) return u;
        else{
            parent[u] = findPar(parent[u]);
            return parent[u];
        }
    }
    public boolean find(int u, int v){
        return findPar(u) == findPar(v);
    }
    
    public void union(int u, int v){
        int paru = findPar(u);
        int parv = findPar(v);
        if(paru == parv) return ;
        if(size[paru] < size[parv]){
            parent[paru] = parv;
            size[parv] += size[paru];
        }
        else{
            parent[parv] = paru;
            size[paru] += size[parv];
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        Disjoint ds = new Disjoint(n);
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    ds.union(i, j);
                }
            }
        }
        int iso = 0;
        for(int i=0; i<n; i++){
            if(i == ds.findPar(i)) iso++;
        }
        return n -iso;
    }
}