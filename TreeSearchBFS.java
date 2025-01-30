import java.util.LinkedList;
import java.util.Queue;

class TreeSearchBFS {
    public static TreeNode findNodeBFS(TreeNode root, int x) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.val == x) return current;

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return null; // Node not found
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        int x = 7;
        TreeNode result = findNodeBFS(root, x);
        System.out.println(result != null ? "Node found: " + result.val : "Node not found");
    }
}

