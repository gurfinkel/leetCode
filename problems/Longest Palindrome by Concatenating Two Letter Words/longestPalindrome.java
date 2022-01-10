class Solution {
    public int longestPalindrome(String[] words) {
        int result = 0;
        boolean centerFlag = false;
        HashMap<String, Integer> store = new HashMap<>();

        for (String word : words) {
            store.put(word, 1 + store.getOrDefault(word, 0));
        }

        for (String key : store.keySet()) {
            if (0 == store.get(key)) {
                continue;
            }
            if (key.charAt(0) == key.charAt(1)) {
                if (1 == (store.get(key)&1)) {
                    if (!centerFlag) {
                        centerFlag = true;
                        result += 2*store.get(key);
                    } else {
                        result += 4*(store.get(key)/2);
                    }
                } else {
                    result += 2*store.get(key);
                }
            } else {
                StringBuilder palindromeKey = new StringBuilder();
                palindromeKey.append(key.charAt(1));
                palindromeKey.append(key.charAt(0));

                if (store.containsKey(palindromeKey.toString())) {
                    result += 4*Math.min(store.get(key), store.get(palindromeKey.toString()));
                    store.put(palindromeKey.toString(), 0);
                }
            }
        }

        return result;
    }
}
