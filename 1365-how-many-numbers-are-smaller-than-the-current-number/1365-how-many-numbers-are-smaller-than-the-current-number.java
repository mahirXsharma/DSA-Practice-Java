class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
           map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        Arrays.sort(nums);
        int ans[] = new int[n];
        for(int i=0; i<n; i++){
            if(i !=0 && nums[i-1] == nums[i]) continue;
            ArrayList<Integer> list = map.get(nums[i]);
            for(int num : list){
                ans[num] = i;
            } 
        }
        return ans;
    }
}