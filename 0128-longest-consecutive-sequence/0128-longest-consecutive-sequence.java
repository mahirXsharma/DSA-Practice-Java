class Solution {
    public int longestConsecutive(int[] nums) {
        // 10^5 -> N or Nlogn
        // we can sort->then it will be really easy, but it will take nLogn
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums)  set.add(num);
        int max = 0;
        // it will fail on {100, 4, 101, 3, 2}
        // so how to do we seggregate the groups ? we will be needing hashmap, i mean if yes, then how? i can't think of any way.
        
        for(int num : set){
            int i = num;
            int ans = 0;
            if(!set.contains(i-1)){
                ans++;

                while(true){
                    i++;
                    if(set.contains(i)) ans ++;
                    else break;
                }
                if(ans > max) max = ans;
            }
        }

        return max ;


    }
}