package LinkedList;

import java.util.*;
// *******************************************************

// LinkedList =  Nodes are in 2 parts (data + address)
//                        Nodes are in non-consecutive memory locations
//                        Elements are linked using pointers

//    advantages?
//    1. Dynamic Data Structure (allocates needed memory while running)
//    2. Insertion and Deletion of Nodes is easy. O(1) 
//    3. No/Low memory waste

//    disadvantages?
//    1. Greater memory usage (additional pointer)
//    2. No random access of elements (no index [i])
//    3. Accessing/searching elements is more time consuming. O(n)

//    uses?
//    1. implement Stacks/Queues
//    2. GPS navigation
//    3. music playlist
// *******************************************************

class ListNode {
    // this is for singly linked lists
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class LinkedListsBasics {
    // leetcode-21. Merge Two Sorted Lists

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode sortList(ListNode head) {
        // leetcode-148 sort list

        // brute force 2wo pointers O(n2) time complexity;

        // if (head == null || head.next == null) {
        // return head;
        // }

        // ListNode node = head;

        // while (node != null) {
        // ListNode k = node.next;
        // while (k != null) {
        // if (node.val > k.val) {
        // int t = node.val;
        // node.val = k.val;
        // k.val = t;
        // }
        // k = k.next;
        // }
        // node = node.next;
        // }
        // return head;

        // Optimal-> Merge sort O(n)
        if (head == null || head.next == null)
            return head;

        // Step 1: Find mid
        ListNode mid = midFind(head);

        // Step 2: Split the list
        ListNode right = mid.next;
        mid.next = null; // IMPORTANT: break the list
        ListNode left = head;

        // recursive sorts
        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode midFind(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        if (left.val < right.val) {
            left.next = mergeTwoLists(left.next, right);
            return left;
        } else {
            right.next = mergeTwoLists(left, right.next);
            return right;
        }
    }

    public ListNode swapPairs(ListNode head) {
        // leetcode-24 swap nodes in pairs ;
        if (head == null || head.next == null) {
            return head;

        }
        ListNode newHead = head.next; // second node
        ListNode prev = null;
        ListNode current = head;

        while (current != null && current.next != null) {
            ListNode nextPair = current.next.next; //
            ListNode second = current.next;

            // swap
            second.next = current;
            current.next = nextPair;

            // connecting prev pairs
            if (prev != null) {
                prev.next = second;
            }

            // moving pointers
            prev = current;
            current = nextPair;

        }
        return newHead;
    }

    public ListNode swapNodes(ListNode head, int k) {
        // leetcode-1721 swapping nodes in a Linked List 


        // this is an extra space approach not optimal 
        // List<Integer> list = new ArrayList<>();

        // ListNode current = head;
        // while (current!=null) {
        //     list.add(current.val);
        //     current= current.next;
        // }

        // Collections.swap(list, k-1, list.size()-k); // we can use get and set as well 

        // ListNode dummy =  new ListNode(0);
        // ListNode curr = dummy;

        // for (int integer : list) {
        //     curr.next = new ListNode(integer);
        //     curr = curr.next;
        // }

        // return dummy.next;

        ListNode first = head;

        // goto k
        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        ListNode second = head;
        ListNode temp = first ;

        // move togather its like a moving 2 cars in the same distance appaert if one stops another too 
        while(temp.next!=null){
            temp = temp.next;
            second = second.next;
        }

        // swap 
        int j = second.val;
        second.val = first.val;
        first.val = j;


        return head ;


    }

    // helper: builder
    private static ListNode build(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : vals)
            cur = cur.next = new ListNode(v);
        return dummy.next;
    }

    // helper: printer
    private static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListsBasics sol = new LinkedListsBasics();

        // test mergeTwoLists
        System.out.println("=== mergeTwoLists ===");
        ListNode l1 = build(new int[] { 1, 2, 4 });
        ListNode l2 = build(new int[] { 1, 3, 4 });
        print(sol.mergeTwoLists(l1, l2)); // 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null

        ListNode l3 = build(new int[] {});
        ListNode l4 = build(new int[] { 0 });
        print(sol.mergeTwoLists(l3, l4)); // 0 -> null

        // test sortList
        System.out.println("=== sortList ===");
        ListNode l5 = build(new int[] { 4, 2, 1, 3 });
        print(sol.sortList(l5)); // 1 -> 2 -> 3 -> 4 -> null

        ListNode l6 = build(new int[] { -1, 5, 3, 4, 0 });
        print(sol.sortList(l6)); // -1 -> 0 -> 3 -> 4 -> 5 -> null
    }
}
