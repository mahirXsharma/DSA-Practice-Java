class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, rs = 0;
        for(int num : nums){
            rs += num;
            if(rs == k) count++;
            int key = rs-k;
            if(map.containsKey(key)) count += map.get(key);
            if(map.containsKey(rs)){
                map.put(rs, map.get(rs) + 1);
            }
            else {
                map.put(rs, 1);
            }

        }
        return count;
    }
}