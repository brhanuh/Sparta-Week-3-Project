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

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public void add(Node start, Employee data){

        if (start.data.compareTo(data) == 0){
            if (start.left == null){
                start.left = new Node(data);
            } else {
                add(start.left, data);
            }
        }
        else if(data.compareTo(start.data) < 0){
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
    public void printNodes(Node node) {
        // base case
        if (node == null) {
            return;
        }
        System.out.println(node);
        printNodes(node.left);
        printNodes(node.right);
    }
    public void search(Node n, String s){
        if (n.equals(null)){
            System.out.println(n + " is null");
        }
        else if (s.equals(n.data.getLastName())){
            System.out.println(n.data.fullToString());
            if (n.left != null && n.left.data.getLastName().equals(s)){
                search(n.left,s);
            }
        }
        else if(s.compareTo(n.data.getLastName()) < 0){
            if(n.left != null) {
                search(n.left, s);
            } else
                System.out.println("Employee not in the sample");
        }
        else {
            if (n.right != null) {
                search(n.right, s);
            } else
                System.out.println("Employee not in the sample");
        }
    }
}
