class Solution {
    public int[][] merge(int[][] intervals) {
        int n  = intervals.length;
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int curr[] = intervals[0];
        for(int i=1; i<n; i++){
            int next[] = intervals[i];
            if(curr[1] >= next[0]){
                curr[1] = Math.max(curr[1], next[1]);
            }
            else {
                 ans.add(new int[]{curr[0], curr[1]});
                 for(int k=0; k<2; k++) curr[k] = intervals[i][k];
                }
        }
        ans.add(new int[]{curr[0], curr[1]});
        return ans.toArray(new int[ans.size()][]);
        // int finalAns[][] = new int[ans.size()][2];
        // for(int i=0; i<ans.size(); i++){
        //     int newcurr[] = ans.get(i);
        //     finalAns[i][0] = newcurr[0];
        //     finalAns[i][1] = newcurr[1];
        // }
        // return finalAns;
    }
}