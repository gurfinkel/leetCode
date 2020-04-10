public class MinStack {

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void Push(int x) {
        _stack.Push(x);

        if (0 < _minStack.Count) {
            _minStack.Push(Math.Min(_minStack.Peek(), x));
        } else {
            _minStack.Push(x);
        }
    }

    public void Pop() {
        if (0 < _stack.Count) {
            _stack.Pop();
            _minStack.Pop();
        }
    }

    public int Top() {
        return _stack.Peek();
    }

    public int GetMin() {
        return _minStack.Peek();
    }

    private Stack<int> _minStack = new Stack<int>();
    private Stack<int> _stack = new Stack<int>();
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.Push(x);
 * obj.Pop();
 * int param_3 = obj.Top();
 * int param_4 = obj.GetMin();
 */
