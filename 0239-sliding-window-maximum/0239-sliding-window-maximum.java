class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, idx = 0;
        // why use int[] why not a custom class or Integer,Intneger ? 
        int ans[] = new int[n-k+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[1], a[1]));

        for(int i=0; i<n; i++){
            pq.add(new int[]{i, nums[i]});

            while(!pq.isEmpty() && pq.peek()[0] <= i-k) pq.poll();

            if(i >= k-1){
                ans[idx++] = pq.peek()[1];
            }
        }
        return ans;

    }
}