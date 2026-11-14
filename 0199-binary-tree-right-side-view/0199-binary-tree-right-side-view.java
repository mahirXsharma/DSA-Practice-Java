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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // last node in the level order traversal
        // TreeNode curr = new TreeNode <>() -> do we use '<>' here?
        if(root == null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode last = null;
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                last = curr; 
            }
            ans.add(last.val);
        }
        return ans;

    }
}