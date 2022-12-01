package Model;

public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    void add(Node start, int data){
        // don't actually need this logic. All cases are covered
//        if (start.data == data){
//            return;
//        }
        if(data < start.data){
            if (start.left == null){
                start.left = new Node(data);
            }
            else {
                add(start.left, data);
            }
        }
        else if (data > start.data){
            if (start.right == null){
                start.right = new Node(data);
            }
            else {
                add(start.right, data);
            }
        }
    }
}
