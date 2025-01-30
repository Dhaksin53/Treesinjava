class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class TreeSearchdfs {
    public static TreeNode findNodeDFS(TreeNode root, int x) {
        if (root == null) return null;
        if (root.val == x) return root;

        TreeNode leftSearch = findNodeDFS(root.left, x);
        if (leftSearch != null) return leftSearch;

        return findNodeDFS(root.right, x);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        int x = 7;
        TreeNode result = findNodeDFS(root, x);
        System.out.println(result != null ? "Node found: " + result.val : "Node not found");
    }
}
