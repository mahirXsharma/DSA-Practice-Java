class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] s = new String[n];
        for(int i=0; i<n; i++){
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (a,b)->
            (b+a).compareTo(a+b)
        );
        StringBuilder sb = new StringBuilder();
        for(String curr : s){
            sb.append(curr);
        }
        String res = sb.toString();
        if(res.charAt(0) == '0') return "0";
        return res;
    }
}