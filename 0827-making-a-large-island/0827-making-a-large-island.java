class Disjoint {
    int[] parent;
    int[] size;

    public Disjoint(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
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

    public boolean find(int u, int v) {
        return findPar(u) == findPar(v);
    }

    public void union(int u, int v) {
        int paru = findPar(u), parv = findPar(v);
        if (paru == parv)
            return;
        if (size[paru] < size[parv]) {
            parent[paru] = parv;
            size[parv] += size[paru];
        } else {
            parent[parv] = paru;
            size[paru] += size[parv];
        }
    }
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Disjoint ds = new Disjoint(n * n);
        int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        // counting already present islands
        int currMaxSize = 0;
        for (int i=0; i<n; i++) {
            int curr[] = grid[i];
            for(int j=0; j<curr.length; j++){
                int currCor = i * n + j;
                if(curr[j] == 1){
                    if(currMaxSize == 0) currMaxSize = 1;
                    for (int dir[] : dirs) {
                        int nextR = i + dir[0], nextC = j + dir[1];
                        int parCor = nextR * n + nextC;
                        if (nextR < n && nextR >= 0 && nextC < n && nextC >= 0) {
                            if (grid[nextR][nextC] == 1) {
                                int currOr = ds.findPar(currCor);
                                int currPar = ds.findPar(parCor);
                                if (currPar != currOr) {
                                    ds.union(parCor, currCor);
                                    currMaxSize = Math.max(currMaxSize, ds.size[ds.findPar(currOr)]);
                                }
                            }
                        }
                    }
                }
            }            
        }
        // Flipping the zeros

        HashSet<Integer> uniqueBosses = new HashSet<>();
        for (int i=0; i<n; i++) {
            int curr[] = grid[i];
            for(int j=0; j<curr.length; j++){
                int currCor = i * n + j;
                if(grid[i][j] == 0){
                    int currAns = 1;
                    uniqueBosses.clear();
                    for(int dir[] : dirs){
                        int nextR = i + dir[0], nextC = j + dir[1];
                        if(nextR >=0 && nextR < n && nextC < n && nextC >=0){
                            if(grid[nextR][nextC] == 1){
                                int broCor = nextR * n + nextC;
                                uniqueBosses.add(ds.findPar(broCor));
                            }
                        }
                    }
                    for(int boss : uniqueBosses){
                        currAns += ds.size[boss];
                    }
                    currMaxSize = Math.max(currMaxSize, currAns);
                }
            }            
        }
        return currMaxSize;

    }
}
