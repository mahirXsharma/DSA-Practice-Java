class Solution {
    public String largestNumber(int[] nums) {
        // n -> 100 => any
        // we can't use Array.sort WITH comparator on a normal int[] array
        int n = nums.length;
        String[] arr = new String[n];

        for(int i=0; i<n; i++) arr[i] = String.valueOf(nums[i]);

        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        if(arr[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) sb.append(arr[i]);

        return sb.toString();
    }
}