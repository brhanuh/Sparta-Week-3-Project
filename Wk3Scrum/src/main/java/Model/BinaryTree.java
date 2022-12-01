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
        // don't actually need this logic. All cases are covered
//        if (start.data == data){
//            return;
//        }
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
}
