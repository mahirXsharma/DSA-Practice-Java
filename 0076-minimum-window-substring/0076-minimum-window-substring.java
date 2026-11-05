class Solution {
    public String minWindow(String s, String t) {
        int arr[] = new int[128];
        for (char ch : t.toCharArray()) {
            arr[ch]++;
        }
        for (int i = 0; i < 128; i++) {
            if (arr[i] == 0)
                arr[i] = -1;
        }

        int l = 0, r = 0, ans = Integer.MAX_VALUE, match = 0;
        int m = s.length(), n = t.length(), right = 0, left = 0;
        while (r < m) {
            char curr = s.charAt(r);
            if (arr[curr] > 0)
                match++;
            arr[curr]--;

            while (match == n && l < m) {
                char atLeft = s.charAt(l);
                if (arr[atLeft] == 0)
                    break;
                else {
                    arr[atLeft]++;
                    l++;
                }
            }
            if (match == n) {
                int currlen = r - l+1;
                if (currlen < ans) {
                    ans = currlen;
                    right = r;
                    left = l;
                }
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(left, right + 1);
    }
}