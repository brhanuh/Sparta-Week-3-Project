package Model;

public class BinaryTree {
    public static class Node{
        Employee data;
        Node left;
        Node right;

        public Node(Employee data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void add(Node start, Employee data){

        if(data.compareTo(start.data) < 0){
            if (start.left == null){
                start.left = new Node(data);
            }
            else {
                add(start.left, data);
            }
        }
        else if (data.compareTo(start.data) > 0){
            if (start.right == null){
                start.right = new Node(data);
            }
            else {
                add(start.right, data);
            }
        }
    }

    public static void printleafNodes(Node node){
        if(node != null){
            return;
        }
        if(node.left == null && node.right == null){
            System.out.println(node);
        }
        printleafNodes(node.left);
        printleafNodes(node.right);
    }
    //TODO: Dereference of node will produceNullPointerException
    // Will fix or test this
}
