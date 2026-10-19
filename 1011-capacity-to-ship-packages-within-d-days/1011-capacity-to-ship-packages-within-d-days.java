class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int totalWeight= 0, maxWt = 0;
        for(int weight : weights){
            totalWeight += weight;
            if(weight > maxWt) maxWt = weight;
        }

        int si = maxWt, ei = totalWeight;
        int ans = 0;
        while(si <= ei){
            int mid = (si + (ei-si)/2);
            int d = help(weights, mid);
             if(d > days){
                si = mid+1;
             }
            else{
                ei = mid-1;
                ans = mid;
            }
        } 
        return ans;
    }

    public int help(int nums[], int max){
        int daysNeeded = 0;
        int cs = 0;
        for(int num : nums){
            cs += num;
            if(cs > max){
                daysNeeded ++;
                cs = num;
            }
        }
        return daysNeeded+1;
    }
}