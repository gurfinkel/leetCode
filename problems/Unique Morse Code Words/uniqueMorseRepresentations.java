class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashMap<Character, String> map = new HashMap<Character, String>() {{
            put('a', ".-");
            put('b', "-...");
            put('c', "-.-.");
            put('d', "-..");
            put('e', ".");
            put('f', "..-.");
            put('g', "--.");
            put('h', "....");
            put('i', "..");
            put('j', ".---");
            put('k', "-.-");
            put('l', ".-..");
            put('m', "--");
            put('n', "-.");
            put('o', "---");
            put('p', ".--.");
            put('q', "--.-");
            put('r', ".-.");
            put('s', "...");
            put('t', "-");
            put('u', "..-");
            put('v', "...-");
            put('w', ".--");
            put('x', "-..-");
            put('y', "-.--");
            put('z', "--..");
        }};
        HashSet<String> store = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        int result = 0;

        for (String word : words) {
            sb.delete(0, sb.length());

            for (int idx = 0; word.length() > idx; ++idx) {
                sb.append(map.get(word.charAt(idx)));
            }

            if (!store.contains(sb.toString())) {
                store.add(sb.toString());
                ++result;
            }
        }

        return result;
    }
}
