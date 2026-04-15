package LinkedList;

public class SinglyLinkedList {

    class Node {
        int data; // data
        Node next; // pointer to the next

        // constructor for the ll
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        // initialisartion
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head; // maintaining head globally

    // insert node at head
    public void insertAtHead(int value) {
        Node node = new Node(value); // create new node
        node.next = head;            // point to previous head
        head = node;                 // update head
    }

    // print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int linkedListLength(){
        int total = 0;
        // we need to from head to the last null
        Node temp = head;
        while (temp!=null) {
            total++;
            temp=temp.next; //moving to the next node 
        }
        return total;


        //initialise the temp pointer to the 
    }

    public int searchLinkedList(int value ){
        Node node = head;
       while (node != null) {
        if (node.data==value) {
            return value;
        }
        node = node.next;
       }
       return -1;
    }
    public int searchIndexLinkedList(int value){
        Node node = head;
        int index=0;
        while (node!=null) {
            if (node.data==value) {
                return index;
            }
            node = node.next;
            index++;
            
        }
        return index;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] arr = { 1, 2, 3, 4, 5 };

        // build the linked list using insertAtHead
        for (int i = arr.length - 1; i >= 0; i--) {
            list.insertAtHead(arr[i]);
        }

        // print the linked list
        list.printList();
    }
}