public class Solution {
    public int Compress(char[] chars) {
        var idx = 0;
        var counter = 1;

        for (var i = 0; chars.Length > i; ++i) {
            if (chars.Length == 1 + i || chars[1 + i] != chars[i]) {
                chars[idx++] = chars[i];

                if (1 < counter) {
                    var str = counter.ToString();
                    for (var j = 0; str.Length > j; ++j) {
                        chars[idx++] = str[j];
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
