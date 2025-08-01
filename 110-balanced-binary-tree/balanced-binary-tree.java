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
    public boolean isBalanced(TreeNode root) {
        pair ans=solve(root);
        return ans.isbal;
        
    }
    public pair solve(TreeNode root){
        if(root==null){
            return new pair(0,true);
        }
        pair left=solve(root.left);
        pair right=solve(root.right);

        boolean isbal=left.isbal && right.isbal && Math.abs(left.height-right.height) <=1;
        int hegiht=Math.max(left.height,right.height)+1;

        return new pair(hegiht,isbal);
    }
    class pair{
        int height;
        boolean isbal;

        public pair(int ht,boolean isba){
            height=ht;
            isbal=isba;
        }
    }
}