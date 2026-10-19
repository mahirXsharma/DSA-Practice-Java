class Solution {
    public int findKthPositive(int[] arr, int k) {
        int mis = -1, n = arr.length, curr = 1;
        int i=0;
        while(i< n){
            if(k == 0) return mis;
            else if(curr == arr[i]) i++;
            else{
                mis = curr;
                k--;
            }
            curr++;
        }
        return curr + k-1;
    }
}