class Solution {
    public List<Integer> findLonely(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        // HASHMAP
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : nums){
            boolean lonely = true;
            if(map.get(num)>1) lonely = false;
            if(map.containsKey(num-1) || map.containsKey(num+1)) lonely = false;
            if(lonely) ans.add(num);
        }
        return ans;


















        // Arrays.sort(nums);
        // int n =nums.length;
        // for(int i=0; i<n; i++){
        //     boolean lonely = true;
        //     if(i+1 < n ){
        //         if(nums[i+1] == nums[i] + 1 || nums[i+1] == nums[i]) lonely = false;
        //     }
        //     if(i-1 >= 0){
        //         if( nums[i-1] == nums[i] || nums[i-1] == nums[i]-1)lonely = false;
        //     } 
        //     if(lonely) ans.add(nums[i]);
        // }
        // return ans;        
    }
}