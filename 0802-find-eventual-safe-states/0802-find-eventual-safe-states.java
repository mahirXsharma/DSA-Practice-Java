class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int degree[] = new int[n];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i<n; i++) arr.add(new ArrayList<>());
        for(int i=0; i<n; i++){
            degree[i] = graph[i].length;
            for(int num : graph[i]){
                arr.get(num).add(i);
            }
        }
        for(int i=0; i<n; i++){
            if(degree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int num : arr.get(curr)){
                degree[num]--;
                if(degree[num] == 0) q.add(num);
            }
        }
        for(int i=0; i<n; i++){
            if(degree[i] == 0) ans.add(i);
        }
        return ans;
    }
}