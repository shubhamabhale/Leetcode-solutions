class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        // If either p or q is found, return that node
        if (root == p || root == q)
            return root;

        // Recursively search for p and q in the left and right subtrees
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both leftLCA and rightLCA are not null, it means we found p and q in both subtrees,
        // so the current root is the lowest common ancestor.
        if (leftLCA != null && rightLCA != null)
            return root;

        // If only one of leftLCA or rightLCA is not null, return that non-null value.
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}
