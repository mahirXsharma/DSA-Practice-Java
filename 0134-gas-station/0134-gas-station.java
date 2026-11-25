class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        // tc -> N * N (?, i mean, i think N^2 is possible in this case)
        for(int i=0; i<n; i++){
            int fuel = gas[i], prev = 0;
            if(fuel >= cost[i]){
                // found a starting, now run a while loop to check
                prev = fuel - cost[i];
                int idx = (i + 1)%n;
                while(idx != i){
                    fuel = prev + gas[idx];
                    if(fuel - cost[idx] >= 0){
                        prev = fuel - cost[idx];
                        idx = (idx + 1)%n;
                    }
                    else break;
                }
                if(idx == i ) return i;
                else if(idx < i) return -1;
                else  i = idx;
            } 
        }
        return -1;
    }
}