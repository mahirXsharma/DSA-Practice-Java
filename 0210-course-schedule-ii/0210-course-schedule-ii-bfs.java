class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses, p = n-1;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int degree[] = new int[n];
        int ans[] = new int[n];
        for (int i = 0; i < n; i++)
            arr.add(new ArrayList<>());
        for (int[] curr : prerequisites) {
            arr.get(curr[0]).add(curr[1]);
            degree[curr[1]] ++;
        }
        for(int i=0; i<n; i++){
            if(degree[i]== 0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[p--] = curr;
            for(int num : arr.get(curr)){
                degree[num]--;
                if(degree[num] == 0)q.add(num);
            }
        }
        for(int num : degree){
            if(num != 0) return new int[]{};
        }
        return ans;
    }
}






