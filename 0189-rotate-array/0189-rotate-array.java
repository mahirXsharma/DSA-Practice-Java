class Solution {
    public void rotate(int[] nums, int k) {
        // 10^5 -> Straight up N
        // i can do this with N extra space
        // N both tc and sc
        int n = nums.length;
        int K = k % n;
        // rever the whole array
        reverse(nums, 0, n-1);
        // reverse kth portion of the array
        reverse(nums, 0, K-1);
        reverse(nums, K, n-1);
    }

    public void reverse(int[] arr, int s, int e){
        while(s < e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}