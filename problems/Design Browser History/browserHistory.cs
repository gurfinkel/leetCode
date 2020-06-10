public class BrowserHistory {

    private Stack<string> _backStack = new Stack<string>();
    private Stack<string> _forwardStack = new Stack<string>();
    private string _currUrl;

    public BrowserHistory(string homepage) {
        _currUrl = homepage;
    }

    public void Visit(string url) {
        _backStack.Push(_currUrl);
        _forwardStack.Clear();
        _currUrl = url;
    }

    public string Back(int steps) {
        if (0 < _backStack.Count) {
            _forwardStack.Push(_currUrl);
        }

        while (1 < steps-- && 1 < _backStack.Count) {
            _forwardStack.Push(_backStack.Pop());
        }

        if (0 < _backStack.Count) {
            _currUrl = _backStack.Pop();
        }

        return _currUrl;
    }

    public string Forward(int steps) {
        if (0 < _forwardStack.Count) {
            _backStack.Push(_currUrl);
        }

        while (1 < steps-- && 1 < _forwardStack.Count) {
            _backStack.Push(_forwardStack.Pop());
        }

        if (0 < _forwardStack.Count) {
            _currUrl = _forwardStack.Pop();
        }

        return _currUrl;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.Visit(url);
 * string param_2 = obj.Back(steps);
 * string param_3 = obj.Forward(steps);
 */
