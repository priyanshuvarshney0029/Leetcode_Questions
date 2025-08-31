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
    public TreeNode deleteNode(TreeNode root, int key) {
         if(root==null){
            return root;
         }
         if(root.val < key){
             root.right=deleteNode(root.right,key);
         }
         if(root.val > key){
            root.left=deleteNode(root.left,key);
         }
         if(root.val == key){
             if(root.left==null && root.right==null){
                return null;
             }
             if(root.left==null){
                return root.right;
             }
             if(root.right==null){
                return root.left;
             }
             int val=left_most(root.right);
             root.val=val;
             root.right=deleteNode(root.right,root.val);
             

         }
         return root;
    }
    public int left_most(TreeNode root){
        while(root.left!=null){
             root=root.left;
        }
        return root.val;
    }
}