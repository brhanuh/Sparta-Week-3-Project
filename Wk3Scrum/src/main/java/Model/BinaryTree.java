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
        // don't actually need this logic. All cases are covered
//        if (start.data == data){
//            return;
//        }
        //System.out.println();
        if(data.compareTo(start.data) < 0){
            if (start.left == null){
                start.left = new Node(data);
//                System.out.println("assigned left: " + data.getEmployeeNumber());
            }
            else {
                add(start.left, data);
            }
        }
        else if (data.compareTo(start.data) > 0){
            if (start.right == null){
                start.right = new Node(data);
//                System.out.println("Assigned right: " + data.getEmployeeNumber());
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
//        if (node.left == null && node.right == null) {
//            //System.out.println(node.toString());
//        }
        System.out.println(node);
        printNodes(node.left);
        printNodes(node.right);
    }
    public void search(Node n, String s){
        if (n.equals(null)){
            System.out.println(n + " is null");
            System.out.println(s + " not found");
        }
        else if (s.equals(n.data.getLastName())){
            System.out.println(n.data.fullToString());
        }
        else if(s.compareTo(n.data.getLastName()) < 0){
            search(n.left,s);
        }
        else search(n.right,s);
    }
}
