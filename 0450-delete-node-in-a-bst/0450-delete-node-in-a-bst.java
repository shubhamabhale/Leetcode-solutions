class Solution {
    public TreeNode inOrderSuccessor(TreeNode node) {
        if (node == null)
            return null;

        if (node.right != null) {
            TreeNode temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }

        return null;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            TreeNode inorderSuccessor = inOrderSuccessor(root);
            root.val = inorderSuccessor.val;
            root.right = deleteNode(root.right, inorderSuccessor.val);
        }

        return root;
    }
}
