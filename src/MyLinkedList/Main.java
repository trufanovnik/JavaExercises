package MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(5);
        list.add(5);
        list.add(4);

        System.out.println("List:");
        list.print();

        list.delete(5);

        System.out.println("Modified list:");
        list.print();
    }
}
