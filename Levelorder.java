
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int value){
        this.val= value;
        this.left=null;
        this.right=null;
    }
}

public class Levelorder {
    public  static void levelorder(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode current=queue.poll();
            System.out.print(current.val+ " ");
            if(current.left !=null){

             queue.add(current.left);
            }
            if(current.right !=null)
            {

             queue.add(current.right);}

        }
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Level order traversal");
        levelorder(root);

    }
    
}
