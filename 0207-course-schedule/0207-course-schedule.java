class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int degree[] = new int[n];
        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            arr.add(new ArrayList<>());
        }
        for(int curr[] : prerequisites){
            arr.get(curr[0]).add(curr[1]);
            degree[curr[1]] ++ ;
        }
        for(int i=0; i<n; i++){
            if(degree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            // decrease the outgoing edges from this curr
            for(int num : arr.get(curr)){
                degree[num]--;
                if(degree[num] == 0) q.add(num);
            }
        }
        for(int num : degree) if(num != 0) return false;
        return true;
    }
}