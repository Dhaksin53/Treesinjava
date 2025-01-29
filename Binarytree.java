
import java.util.Scanner;

class Node{
    int val;
    Node left;
    Node right;
    Node(int value) {
        this.val = value;
        this.right=null;
        this.left=null;
    }
}
public class Binarytree{
        static Scanner sc=new Scanner(System.in);
        public static Node createTree() {
            System.out.println("enter node and -1 for no node");
            int value=sc.nextInt();
            if(value==-1){
                return null;
            }
            Node newNode=new Node(value);
            System.out.println("Enter the leftchild+value");
            newNode.left=createTree();
            System.out.println("Enter the rightchild+value");
            newNode.right=createTree();
            return newNode;
        }
        public static void preorder(Node root) {
            if(root==null){
                return;
            }
            System.out.println(root.val +" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void main(String[] args) {
            Node root=createTree();
            System.out.println("preoder traversal of the root ");
            preorder(root);
        }
}