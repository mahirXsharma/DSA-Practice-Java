class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), ans = 0;
        int freq[] = new int[3];
        for(int i=0; i<3; i++) freq[i] = -1;

        for(int i=0; i<n; i++){
            freq[s.charAt(i) - 'a'] = i;
            boolean check = true;
            for(int p=0; p<3; p++){
                if(freq[p] == -1) check = false;
            }
            if(check){
                int idx = Math.min(freq[0], Math.min(freq[1], freq[2]));
                ans += idx+1;
            }
        }
        return ans;
    }
}