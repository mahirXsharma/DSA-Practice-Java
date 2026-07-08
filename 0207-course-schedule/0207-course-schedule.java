class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean vis[] = new boolean[numCourses];
        boolean pathVis[] = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] curr : prerequisites) {
            list.get(curr[1]).add(curr[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (dfs(i, vis, pathVis, list))
                    return false;
            }

        }
        return true;
    }
    public boolean dfs(int i, boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> list){
        if(pathVis[i] == true) return true;
        if(vis[i] == true) return false;
        vis[i] = true;
        pathVis[i] = true;
        ArrayList<Integer> curr = list.get(i);
        if(!curr.isEmpty()){
            for(int bro : curr){
                if(dfs(bro, vis, pathVis, list) == true) return true;

            }
        }
        pathVis[i] = false;
        return false;
    }
} 