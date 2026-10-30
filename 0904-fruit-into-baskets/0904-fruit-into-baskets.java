class Solution {
    public int totalFruit(int[] fruits) {
        
        int n = fruits.length;
        int freq[] = new int[n];
        int right = 0, left = 0, dc = 0, max = 0;

        while(right < n){
            int curr = fruits[right];
            if(freq[curr] == 0){
                dc++;
            }
            freq[curr]++;
            while(dc > 2){
                int leftEle = fruits[left];
                freq[leftEle]--;
                if(freq[leftEle] == 0) dc--;
                left++;
            }
            int winSize = right - left + 1;
            if(winSize > max) max = winSize;
            right ++;
        }        
        return max;

    }
}