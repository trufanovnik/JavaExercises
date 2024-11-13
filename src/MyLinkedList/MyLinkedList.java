package MyLinkedList;

public class MyLinkedList {
    public Node head;

    public MyLinkedList(){
        this.head = null;
    }

    public void add(Object value){
        Node newNode = new Node(value);
        Node current = head;
        if(head == null) {
            head = newNode;
        }else {
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void delete(Object value){
        Node current = head;
        Node previous = null;
        while (current.next != null) {
            if(current.value == value) {
                if(current == head) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
            }
            previous = current;
            current = current.next;
        }
    }

    public void print(){
        Node currentNode = head;
        if(head != null)
            System.out.println(head.value);
        while (currentNode.next != null){
            currentNode = currentNode.next;
            System.out.println(currentNode.value);
        }
    }
}
