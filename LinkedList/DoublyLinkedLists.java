package LinkedList;

import java.util.HashSet;

/*
 * Doubly Linked List
 * ------------------
 * Each node has:
 *   - data: the value stored
 *   - next: pointer to the next node
 *   - prev: pointer to the previous node
 *
 * Unlike singly LL, you can traverse both forward and backward.
 * Head → [prev=null | data | next] ↔ [prev | data | next] ↔ ... ↔ [prev | data | next=null] ← Tail
 *
 * Operations:
 *   insertAtHead  - O(1): add node before current head
 *   insertAtTail  - O(n): traverse to end, add node
 *   deleteAtHead  - O(1): move head forward, unlink old head
 *   deleteAtTail  - O(n): traverse to tail, unlink it via prev pointer
 *   display       - O(n): print all nodes forward
 */
public class DoublyLinkedLists {

    // Node: holds data + two pointers (prev and next)
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head; // points to the first node in the list

    // insertAtHead: creates a new node and places it before the current head
    // new node's next → old head, old head's prev → new node, head = new node
    public void insertAtHead(int data) {
        // dummy node to banatei hbe
        Node node = new Node(data);
        // new node to current head
        node.next = head;
        node.prev = null;
        // if list not empty
        if (head != null) {
            head.prev = node;
        }
        // move head to new node
        head = node;

    }

    // insertAtTail: traverses to the last node and links the new node after it
    // last node's next → new node, new node's prev → last node
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        // for empty lists
        if (head == null) {
            head = newNode;
            return;
        }

        // trivarse the last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // link the nodes
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = null;
    }

    // deleteAtHead: removes the first node
    // move head to head.next, set new head's prev to null
    public void deleteAtHead() {
        if (head == null) {
            System.out.println("DLL is empty");
            return;
        }
        // only one node
        if (head.next == null) {
            head = null;
            return;
        }
        // more than one node
        head = head.next;
        head.prev = null;
    }

    // deleteAtTail: traverses to the last node and unlinks it using prev pointer
    // second-to-last node's next → null
    public void deleteAtTail() {
        if (head == null) {
            System.out.println("DLL is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        // উo to last node
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        //  remove last node
        tail.prev.next = null;
    }


    public void reverseDoublyLL(){
        if(head==null||head.next==null) return;

        Node current = head;
        Node temp = null;
        while(current!=null){
            temp = current.prev;
            current = current.prev;
            current.next = temp;

            // move the pointer 
            current = current.prev;
        }
        
        // update the head 
        if (temp!=null) {
            head=temp.prev;
        }
    }

    

    // display: prints all nodes from head to tail
    // format: 1 <-> 2 <-> 3 <-> null
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedLists dll = new DoublyLinkedLists();

        dll.insertAtTail(1);
        dll.insertAtTail(2);
        dll.insertAtTail(3);
        dll.insertAtHead(0);
        dll.display(); // 0 <-> 1 <-> 2 <-> 3 <-> null

        dll.deleteAtHead();
        dll.display(); // 1 <-> 2 <-> 3 <-> null

        dll.deleteAtTail();
        dll.display(); // 1 <-> 2 <-> null
    }
}
