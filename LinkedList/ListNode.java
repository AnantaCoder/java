package LinkedList;

import org.w3c.dom.NodeList;

import java.util.*;

// this is the data structure of a singly linked lists 
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    };

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // create a dummy node
        ListNode node = new ListNode(0);
        node.next = head;
        // initialise two pointers
        ListNode fast = node;
        ListNode slow = node;

        // move fast pointer n+1 ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // move both pointers togather
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // delete that node
        slow.next = slow.next.next;

        return node.next;

    }

    public ListNode deleteMiddle(ListNode head) {
        // leetcode-2095. Delete the Middle Node of a Linked List
        /* leetcode75-linkedList-1 */
        if (head == null || head.next == null) {
            return null;
        }
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        int middle = 0;

        middle = (count / 2);

        current = head;
        for (int i = 0; i < middle - 1; i++) {
            current = current.next; // it will go to the muddle node(updated every time)
        }
        current.next = current.next.next;
        return head;
    }

    public ListNode middleNode(ListNode head) {
        // leetcode-876. Middle of the Linked List

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public boolean hasCycle(ListNode head) {
        // leetcode-141 LinkedList cycle

        // this is good with O(n)
        // ListNode current = head;
        // HashSet<ListNode> set = new HashSet<>();

        // while(current!=null){
        // if (set.contains(current)) {
        // return true;
        // }
        // set.add(current);
        // current = current.next;
        // }
        // return false;

        // floyds algo using slow and fast pointers

        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;

            }
        }
        return false;
    }

    public ListNode oddEvenList(ListNode head) {
        // leetcode-328 Odd even linkedlist
        /* leetcode75-linkedList-2 */
        /*
         * 
         * if (head == null) return null;
         * 
         * List<Integer> arr = new ArrayList<>();
         * ListNode temp = head;
         * 
         * while (temp != null) {
         * arr.add(temp.val);
         * temp = temp.next;
         * }
         * temp = head;
         * for (int i = 0; i < arr.size(); i += 2) {
         * temp.val = arr.get(i);
         * temp = temp.next;
         * }
         * 
         * for (int i = 1; i < arr.size(); i += 2) {
         * temp.val = arr.get(i);
         * temp = temp.next;
         * }
         * 
         * return head;
         */
        if (head != null) {
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;

    }

    public boolean isPalindrome(ListNode head) {
        // leetcode-234 palindrome LinkedList Check
        /*
         * Stack<Integer> stack = new Stack<>();
         * 
         * ListNode temp = head;
         * while (temp!=null) {
         * stack.push(temp.val);
         * temp=temp.next;
         * }
         * 
         * // again trvarse
         * temp=head ;
         * while (temp!=null) {
         * if (temp.val!= stack.pop()) {
         * return false;
         * }
         * temp = temp.next;
         * }
         * return true;
         */

        // better [extra data structure to 0(N) space complexity ] approach using two
        // pointers :-------

        // List<Integer> arr = new ArrayList<>();
        // first store the value in array list then use two pointers to maitain the
        // lists check palindrome .
        /*
         * while (head!=null) {
         * arr.add(head.val);
         * head=head.next;
         * }
         * 
         * // ;eft n right
         * int left = 0 ;
         * int right = arr.size()-1;
         * 
         * while (left<right) {
         * if (!arr.get(left).equals(arr.get(right))) {
         * return false;
         * 
         * }
         * left++;
         * right --;
         * }
         * return true;
         */
        // best approach slow and fast pointer to find the middle

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast is moving twice as fast as the slow pointer node

        // since slow us at half after the trivarsal
        ListNode prev = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;

    }

    public ListNode reverseList(ListNode head) {
        // leetcode-206 reverse the linked list
        /* leetcode75-linkedList-3 */

        // brute force using stack
        // Stack<Integer> stack = new Stack<>();

        // ListNode temp = head;
        // while (temp!=null) {
        // stack.push(temp.val);
        // temp=temp.next;
        // }
        // temp = head; //move temp back to head
        // while (temp!=null) {
        // temp.val=stack.pop();
        // temp = temp.next;
        // }

        // return head;

        // optimal solution
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;

    }

    // helper: build a linked list from an array
    private ListNode build(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : vals)
            cur = cur.next = new ListNode(v);
        return dummy.next;
    }

    // helper: print linked list as 1 -> 2 -> 3 -> null
    private void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // test removeNthFromEnd
        System.out.println("=== removeNthFromEnd ===");
        ListNode list1 = sol.build(new int[] { 1, 2, 3, 4, 5 });
        sol.print(sol.removeNthFromEnd(list1, 2)); // 1 -> 2 -> 3 -> 5 -> null

        ListNode list2 = sol.build(new int[] { 1 });
        sol.print(sol.removeNthFromEnd(list2, 1)); // null

        // test deleteMiddle
        System.out.println("=== deleteMiddle ===");
        ListNode list3 = sol.build(new int[] { 1, 2, 3, 4, 5 });
        sol.print(sol.deleteMiddle(list3)); // 1 -> 2 -> 4 -> 5 -> null

        ListNode list4 = sol.build(new int[] { 1, 2, 3, 4 });
        sol.print(sol.deleteMiddle(list4)); // 1 -> 2 -> 4 -> null
    }
}