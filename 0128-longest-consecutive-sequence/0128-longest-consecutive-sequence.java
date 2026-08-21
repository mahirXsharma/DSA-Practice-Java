class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int num : nums){
            set.add(num);
        }
        int ans = 0;
        for(int curr : set){

            if(!set.contains(curr-1)){
                int currNum = curr;
                int streak = 1;
                while(set.contains(currNum + 1)){
                    currNum ++;
                    streak++;
                }
                ans = Math.max(ans, streak);
            }
        }
        return ans;
    }
}