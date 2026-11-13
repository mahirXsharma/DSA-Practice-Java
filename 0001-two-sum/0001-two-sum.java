class Solution {
    public int[] twoSum(int[] nums, int target) {
        // n -> 10^4 -> N
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int curr = nums[i], key = target - curr; 

            if(map.containsKey(key) ){
                return new int[]{map.get(key), i};
            }
            map.put(curr, i);
        }
        return new int[]{-1, -1};
    }
}