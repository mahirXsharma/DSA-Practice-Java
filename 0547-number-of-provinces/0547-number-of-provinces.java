class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        int ans = 0;
        for(int i=0; i<n; i++) list.add(new ArrayList<>());
        for(int i=0; i<n; i++){
            int[] curr = isConnected[i];
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1) list.get(i).add(j);
            }
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                q.add(i);
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int bro : list.get(curr)){
                        if(!visited[bro]){
                            visited[bro] = true;
                            q.add(bro);
                        }
                    }
                }
                ans++;
            }
        }
        return ans;
    }
}