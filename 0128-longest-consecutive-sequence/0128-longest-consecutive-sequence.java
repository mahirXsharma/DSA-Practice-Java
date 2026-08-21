class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int num : nums){
            set.add(num);
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            int curr = nums[i];

            if(!set.contains(curr-1)){
                int currNum = curr;
                int streak = 1;
                while(set.contains(currNum + 1)){
                    set.remove(currNum+1);
                    currNum ++;
                    streak++;
                }
                ans = Math.max(ans, streak);
            }
        }
        return ans;
    }
}