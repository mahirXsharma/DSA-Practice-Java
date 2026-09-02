class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0) return 0;
        int c = 0, a = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(c <s.length && a < g.length){
            int curr = g[a] - s[c];
            if(curr <= 0) a++;
            c++;
        }
        return a;
    }
}