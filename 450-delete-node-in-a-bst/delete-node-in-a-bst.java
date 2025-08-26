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
        if(root.val > key){
            //left..
           root.left= deleteNode(root.left,key);

        }
        if(root.val < key){
            // right..
            root.right= deleteNode(root.right,key);
        }
        if(root.val == key){
            System.out.println(root.val);
             if(root.left==null && root.right==null){
                 return null;
             }
             else if(root.left==null){
                  return root.right;
             }
             else if(root.right==null){
                return root.left;
             }
             else{
                 int rr=right_most(root.right); //4
                 root.val=rr;
                 root.right=deleteNode(root.right,root.val);
             }
        }
        return root;
    }
    public int right_most(TreeNode root){
          while(root.left!=null){
            root=root.left;
          }
          return root.val;
    }
}