class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean pathVis[] =  new boolean[n]; 
        boolean redRope[] = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(!pathVis[i]) dfs(graph, pathVis, redRope, i);
        }
        for(int i=0; i<n; i++){
            if(!redRope[i]) ans.add(i);
        }
        return ans;
    }
    public boolean dfs(int graph[][], boolean pathVis[], boolean redRope[], int i){
        if(redRope[i]) return false;
        if(pathVis[i]) return true;
        pathVis[i] = true;
        redRope[i] = true;
        
        for(int bro : graph[i]){
            if(!dfs(graph, pathVis, redRope, bro)) return false;
        }
        redRope[i] = false;
        return true;
    }
}