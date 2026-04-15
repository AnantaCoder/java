package Queue;

//linear data structure which follows fifo
// eg: ticket counter line 
/*
| Operation            | Description                      |
| -------------------- | -------------------------------- |
| `enqueue(x)`         | Insert element at rear           |
| `dequeue()`          | Remove element from front        |
| `peek()` / `front()` | View front element               |
| `isEmpty()`          | Check if queue is empty          |
| `isFull()`           | (for array queue) check overflow |
*/
/*
3. Types of Queues (Important for Interviews)
1. Simple Queue
Basic FIFO
2. Circular Queue
Avoids wasted space in array
3. Deque (Double Ended Queue)
Insert/delete from both ends
4. Priority Queue
Elements processed based on priority (Heap)
 */
public class ArrayQueue {

    private int[] arrayQueue;
    private int front; // front Index
    private int rear;// rear index
    private int capacity;

    // front → removal pointer (dequeue happens here)
    // rear → insertion pointer (enqueue happens here) , front reads rear writes

    // constructor: initializes the queue with given capacity, front and rear start
    // at -1 (empty)
    public ArrayQueue(int size) {
        capacity = size;
        arrayQueue = new int[capacity];
        front = -1;
        rear = -1;
    }

    public ArrayQueue() {
        this(10);
    }

    public void enqueue(int element) {
        if (rear == capacity - 1) {
            System.out.println("Thr queue ias full");
            return;
        }
        if (front == -1) {
            front = 0; // first element
        }
        rear++;
        arrayQueue[rear] = element;

    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is already empty!");
            return -1;
        }
        int removed = arrayQueue[front];
        front++;
        if (front > rear) {
            { // empty queue
                front = -1;
                rear = -1;
            }

        }
        return removed;
    }

    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arrayQueue[front];
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    // display: shows filled slots as values and empty slots as _
    public void display() {
        System.out.print("Queue: [");
        for (int i = 0; i < capacity; i++) {
            if (i >= front && i <= rear && front != -1) {
                System.out.print(arrayQueue[i]);
            } else {
                System.out.print("_");
            }
            if (i < capacity - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean running = true;

        System.out.println("ArrayQueue Menu:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Peek (front element)");
        System.out.println("4. isEmpty");
        System.out.println("5. isFull");
        System.out.println("6. Display Queue");
        System.out.println("7. Exit");

        while (running) {
            System.out.print("\nEnter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int val = scanner.nextInt();
                    queue.enqueue(val);
                    System.out.println("Enqueued: " + val);
                    break;
                case 2:
                    int removed = queue.dequeue();
                    if (removed != -1)
                        System.out.println("Dequeued: " + removed);
                    break;
                case 3:
                    int frontVal = queue.peek();
                    if (frontVal != -1)
                        System.out.println("Front: " + frontVal);
                    break;
                case 4:
                    System.out.println("isEmpty: " + queue.isEmpty());
                    break;
                case 5:
                    System.out.println("isFull: " + queue.isFull());
                    break;
                case 6:
                    queue.display();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, try 1-7");
            }
        }
        scanner.close();
    }
}
