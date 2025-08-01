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
    public int diameterOfBinaryTree(TreeNode root) {
       return diameterHelper(root).diameter;
     
}
 Pair diameterHelper(TreeNode root) {
    if (root == null) {
        return new Pair(0, 0); // height = 0, diameter = 0
    }

    Pair left = diameterHelper(root.left);
    Pair right = diameterHelper(root.right);

    int height = Math.max(left.height, right.height) + 1;
    int diameterThroughRoot = left.height + right.height;
    int maxDiameter = Math.max(diameterThroughRoot, Math.max(left.diameter, right.diameter));

    return new Pair(height, maxDiameter);
}
class Pair {
    int height;
    int diameter;

    Pair(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
}
}

