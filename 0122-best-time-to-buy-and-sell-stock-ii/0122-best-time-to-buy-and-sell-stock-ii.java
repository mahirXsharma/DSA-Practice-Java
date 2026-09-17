class Solution {
    public int maxProfit(int[] prices) {
        int buy = -1;
        int ans = 0;
        for(int price : prices){
            if(buy != -1 && buy < price){
                ans += price - buy;
            }
            buy = price;
        }
        return ans;
    }
}