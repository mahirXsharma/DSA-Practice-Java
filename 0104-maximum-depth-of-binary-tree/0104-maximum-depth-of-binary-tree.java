/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
import java.io.*;

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
        // size of the array and the array itself
        int n = nextInt();

    }

    public static int maxDepth(TreeNode root) {
        // what if root == null ? should we return 0 or -1? -> I think 0.
        return dfs(root);
    }

    public static int dfs(TreeNode root){
        if( root == null) return 0;

        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;

        return Math.max(left, right);
    }
}