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
        // + path compression
        if(u == parent[u]) return u;
        else {
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
        else if(size[paru] < size[parv]){
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
    public int makeConnected(int n, int[][] connections) {
        int size = connections.length;
        if(size < n -1) return -1;
        Disjoint ds = new Disjoint(n);
        for(int curr[] : connections){
            int u = curr[0], v = curr[1];
            if(!ds.find(u, v)){
                ds.union(u, v);
            }
        }
        int iso = 0;
        for(int i=0; i<n; i++){
            if(ds.findPar(i) == i) iso++;
        }
        return iso-1;


    }
}