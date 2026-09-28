class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, idx = 0;
        // why use int[] why not a custom class or Integer,Intneger ? 
        int ans[] = new int[n-k+1];
        Deque<Integer> d = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            // remove the old numbers
            if(!d.isEmpty() && d.peekFirst() == i-k){
                d.pollFirst();
            }
            //remove the number that are smaller than the new number
            while(!d.isEmpty() && nums[d.peekLast()] <= nums[i]){
                d.pollLast();
            }
            d.addLast(i);
            if(i >= k-1){
                ans[idx++] = nums[d.peekFirst()];
            }
        }
        return ans;
    }
}