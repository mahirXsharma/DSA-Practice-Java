import java.util.*;
class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException{
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException{
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException{
        PrintWriter out = new PrintWriter(System.out);
        int n = nextInt();
        boolean ans = isPowerOfTwo(n);
        out.print(ans);
        out.println();
        out.flush();
    }
    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && (n&(n-1)) == 0;
    }
}