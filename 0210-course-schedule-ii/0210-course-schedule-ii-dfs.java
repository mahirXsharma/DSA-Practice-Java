class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int p[] = new int[1];
        int n = numCourses;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(new ArrayList<>());
        for (int[] curr : prerequisites) {
            arr.get(curr[0]).add(curr[1]);
        }
        boolean pathVis[] = new boolean[n];
        boolean redRope[] = new boolean[n];
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            if(!pathVis[i]){ 
                if(!dfs(arr, pathVis, redRope, ans, i, p) ){
                    return new int[]{};
                }
            }
        }
        return ans;
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> arr, boolean[] pathVis, boolean[] redRope, int[] ans, int i, int[] p) {
        // i think i can remove this first condition
        if(redRope[i]) return false;
        if(pathVis[i]) return true;
        pathVis[i] = true;
        redRope[i] = true;
        if(!arr.get(i).isEmpty()){
            for(int bro : arr.get(i)){
                if(!dfs(arr, pathVis, redRope, ans, bro, p)) return false;

            }   
        }
        redRope[i] = false;
        ans[p[0]++] = i;
        return true;

    }
}






