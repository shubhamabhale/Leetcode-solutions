class Solution {
    public TreeNode getParent(TreeNode root, TreeNode p) {
        if (root == null || root == p) {
            return null;
        }

        if (p.val > root.val) {
            TreeNode right = getParent(root.right, p);
            return (right == null) ? root : right;
        } else {
            TreeNode left = getParent(root.left, p);
            return (left == null) ? root : left;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode temp = p.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        TreeNode parent = getParent(root, p);
        while (parent != null && p == parent.right) {
            p = parent;
            parent = getParent(root, parent);
        }

        return parent;
    }
}
