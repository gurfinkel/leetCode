class Solution {
    public boolean isValid(String s) {
        Stack<Character> store = new Stack<Character>();

        for (char letter : s.toCharArray()) {
            if (store.isEmpty() || '(' == letter || '[' == letter || '{' == letter) {
                store.push(letter);
            } else {
                if (')' == letter && '(' != store.pop()) {
                    return false;
                }
                if (']' == letter && '[' != store.pop()) {
                    return false;
                }
                if ('}' == letter && '{' != store.pop()) {
                    return false;
                }
            }
        }

        return store.isEmpty();
    }
}
