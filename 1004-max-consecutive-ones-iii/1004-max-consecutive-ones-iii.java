class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, sum = 0;
        int right = 0, left = 0;
        Queue<Integer> q = new ArrayDeque<>();

        while(right < n){
            int curr = nums[right];
            if(curr == 0){
                q.add(right);
            }

            if(q.size() > k) left = q.poll() + 1;
            right ++;
            int currSum = right -left;
            if(currSum > sum) sum = currSum;
        }
        return sum;
    }
}