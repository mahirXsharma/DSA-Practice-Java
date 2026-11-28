class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, ans = 0, prev = 0;
        int tf = 0, tc = 0;
        for(int i=0; i<n; i++){
            tf+= gas[i];
            tc += cost[i];
        }
        if(tf - tc < 0) return -1;
        for(int i=0; i<n; i++){
            int fuel = gas[i] + prev;
            int currCost = cost[i];
            int rem = fuel - currCost;
            if(rem < 0){
                ans = i+1;
                prev = 0;
            }
            else prev = rem;
        }
        return ans == n ? -1 : ans;
    }
}