import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        map.put(0,1);
        int runningSum = 0;
        for(int num : nums){
            runningSum += num;
            int curr = runningSum - k;
            if(map.containsKey(curr)){
                ans += map.get(curr);
            }
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }
        return ans;
    }
}