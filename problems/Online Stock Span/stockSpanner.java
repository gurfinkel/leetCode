class StockSpanner {

    public StockSpanner() {
        prices = new Stack<Integer>();
        weights = new Stack<Integer>();
    }

    public int next(int price) {
        int w = 1;

        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);

        return w;
    }

    private Stack<Integer> prices;
    private Stack<Integer> weights;
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
