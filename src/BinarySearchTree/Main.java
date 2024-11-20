package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer, String> bt = new BinaryTree<>();

        bt.add(4, "Four");
        bt.add(5, "Five");
        bt.add(6, "Six");
        bt.add(3, "Three");

        bt.get(3);
    }
}
