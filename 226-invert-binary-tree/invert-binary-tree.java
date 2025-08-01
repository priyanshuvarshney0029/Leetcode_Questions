class Solution {
    public TreeNode invertTree(TreeNode root) {
        return solve(root);
    }

    public TreeNode solve(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Recursively invert left and right subtrees
        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);

        // Swap the left and right children
        root.left = right;
        root.right = left;

        return root;
    }
}
