class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int counter = 1;

        for (int i = 0; chars.length > i; ++i) {
            if (chars.length == 1 + i || chars[1 + i] != chars[i]) {
                chars[idx++] = chars[i];

                if (1 < counter) {
                    String str = Integer.toString(counter);
                    for (var j = 0; str.length() > j; ++j) {
                        chars[idx++] = str.charAt(j);
                    }

                    counter = 1;
                }
            } else {
                ++counter;
            }
        }

        return idx;
    }
}
