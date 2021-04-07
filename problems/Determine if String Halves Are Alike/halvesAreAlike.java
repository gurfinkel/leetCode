class Solution {
    public boolean halvesAreAlike(String s) {
        int counter = 0;
        HashSet<Character> store = new HashSet<>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        for (int idx = 0; s.length() > idx; ++idx) {
            if (store.contains(s.charAt(idx))) {
                counter += idx >= (s.length() / 2) ? -1 : 1;
            }
        }

        return 0 == counter;
    }
}
