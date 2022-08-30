class BrowserHistory {

    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currUrl = homepage;
    }

    public void visit(String url) {
        backStack.push(currUrl);
        forwardStack.clear();
        currUrl = url;
    }

    public String back(int steps) {
        if (!backStack.isEmpty()) {
            forwardStack.push(currUrl);
        }

        while (1 < steps-- && 1 < backStack.size()) {
            forwardStack.push(backStack.pop());
        }

        if (!backStack.isEmpty()) {
            currUrl = backStack.pop();
        }

        return currUrl;
    }

    public String forward(int steps) {
        if (!forwardStack.isEmpty()) {
            backStack.push(currUrl);
        }

        while (1 < steps-- && 1 < forwardStack.size()) {
            backStack.push(forwardStack.pop());
        }

        if (!forwardStack.isEmpty()) {
            currUrl = forwardStack.pop();
        }

        return currUrl;
    }

    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currUrl;
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
