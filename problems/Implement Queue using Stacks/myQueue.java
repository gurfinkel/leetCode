class MyQueue {

    public MyQueue() {
        head = new Stack<>();
        tail = new Stack<>();
    }

    public void push(int x) {
        head.push(x);
    }

    public int pop() {
        if (tail.isEmpty()) {
            while (!head.isEmpty()) {
                tail.push(head.pop());
            }
        }

        return tail.pop();
    }

    public int peek() {
        if (tail.isEmpty()) {
            while (!head.isEmpty()) {
                tail.push(head.pop());
            }
        }

        return tail.peek();
    }

    public boolean empty() {
        return head.isEmpty() && tail.isEmpty();
    }

    Stack<Integer> head;
    Stack<Integer> tail;
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
