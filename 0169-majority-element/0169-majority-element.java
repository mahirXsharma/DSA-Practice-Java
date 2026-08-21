class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;
        int count = 0, ans = -1;
        for(int num : nums){
            if(num == ans) count++;
            else{
                count--;
                if(count == -1){
                    ans = num;
                    count = 1;
                }
            }
        }
        return ans;





































        // int count = 1, prev = nums[0];
        // for(int i=1; i<nums.length; i++){
        //     if(nums[i] == prev) count++;
        //     else {
        //         count--;
        //         if(count < 0){
        //             prev = nums[i];
        //             count = 1;
        //         }
        //     }         
        // }
        // return prev;



        // HashMap<Integer,Integer> map = new HashMap<>();
        // int n = nums.length/2;
        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        // for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        //     int key = entry.getKey();
        //     int val = entry.getValue();
        //     if(val > n) return key;
        // }
        // return -1;
    }
}