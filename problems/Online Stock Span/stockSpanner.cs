public class StockSpanner {

    public StockSpanner() {

    }

    public int Next(int price) {
        int w = 1;

        while (0 < _prices.Count && _prices.Peek() <= price) {
            _prices.Pop();
            w += _weights.Pop();
        }

        _prices.Push(price);
        _weights.Push(w);

        return w;
    }

    private Stack<int> _prices = new Stack<int>();
    private Stack<int> _weights = new Stack<int>();
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.Next(price);
 */
