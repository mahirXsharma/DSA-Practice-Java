class Solution {
    public int countMagicalPairs(String s) {
        int n = s.length(), count = 0;

        // building the freq array
        int freq[][] = new int[n][27];
        for(int i=0; i<n; i++){
            boolean seen[] = new boolean[26];
            int d = 0;
            for(int j=i; j<n; j++){
                char curr = s.charAt(j);
                if(!seen[curr-'a']){
                    seen[curr-'a'] = true;
                    d++;
                }
                freq[i][d]++;
            }
        }
        for(int i=0; i<n; i++){
            boolean seen1[] = new boolean[26];
            int d1  = 0;
            for(int j=i; j<n-1; j++){
                char curr1 = s.charAt(j);
                if(!seen1[curr1-'a']){
                    seen1[curr1-'a'] = true;
                    d1++;
                }
                count += freq[j+1][d1];
            }
        }
        return count;
    }


}