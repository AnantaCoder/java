package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class queueStack {
    private Queue<Integer> q;

    public queueStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);

        // rotate previous elements behind the new one
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove(); // removes front (which is top of stack)
    }

    public int top() {
        return q.peek(); // front element is the top
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
