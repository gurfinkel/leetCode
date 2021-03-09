class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> store = new Stack<>();
        Set<Integer> itemsToRemove = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int idx = 0; s.length() > idx; ++idx) {
            if ('(' == s.charAt(idx)) {
                store.push(idx);
            } else if (')' == s.charAt(idx)) {
                if (store.isEmpty()) {
                    itemsToRemove.add(idx);
                } else {
                    store.pop();
                }
            }
        }

        while (!store.isEmpty()) {
            itemsToRemove.add(store.pop());
        }

        for (int idx = 0; s.length() > idx; ++idx) {
            if (!itemsToRemove.contains(idx)) {
                sb.append(s.charAt(idx));
            }
        }

        return sb.toString();
    }
}
