public class Solution {
    // Z algorithm O(n + l)
    public int StrStr(string haystack, string needle) {
        if (0 == needle.Length) {
            return 0;
        }

        // Create concatenated string "P$T"
        var concat = needle + "$" + haystack;
        var l = concat.Length;
        var Z = getZarr(concat);

        // now looping through Z array
        // for matching condition
        for (int i = 0; i < l; ++i) {
            // if Z[i] (matched region) is equal
            // to pattern length we got the pattern

            if (Z[i] == needle.Length) {
                return i - needle.Length - 1;
            }
        }
        return -1;
    }

    private int[] getZarr(string s) {
        var n = s.Length;
        var zArr = new int[n];
        var l = 0;
        var r = 0;

        for (var i = 1; n > i; ++i) {
            if (r < i) {
                l = i;
                r = i;

                while (n > r && s[r - l] == s[r]) {
                    ++r;
                }

                zArr[i] = r - l;
                --r;
            } else {
                // k = i-L so k corresponds to number
                // which matches in [L,R] interval.
                var k = i - l;

                // if Z[k] is less than remaining interval
                // then Z[i] will be equal to Z[k].
                // For example, str = "ababab", i = 3,
                // R = 5 and L = 2
                if (zArr[k] < r - i + 1) {
                    zArr[i] = zArr[k];
                } else {
                    // For example str = "aaaaaa" and
                    // i = 2, R is 5, L is 0

                    // else start from R and
                    // check manually
                    l = i;
                    while (n > r && s[r - l] == s[r]) {
                        ++r;
                    }

                    zArr[i] = r - l;
                    --r;
                }
            }
        }

        return zArr;
    }

    // Knuth Morris Pratt O(n + l)
    public int StrStrKnuthMorrisPratt(string haystack, string needle) {
        var n = haystack.Length;
        var l = needle.Length;

        if (0 == l) {
            return 0;
        }

        var hIdx = 0;
        var nIdx = 0;
        var lps = getLongestPrefixSuffix(needle);

        while (n > hIdx) {
            if (haystack[hIdx] == needle[nIdx]) {
                if (l == 1 + nIdx) {
                    return hIdx - nIdx;
                }
                ++hIdx;
                ++nIdx;
            } else {
                if (0 == nIdx) {
                    ++hIdx;
                } else {
                    nIdx = lps[nIdx - 1];
                }
            }

            if (l == nIdx) {
                return hIdx - nIdx;
            }
        }

        return -1;
    }

    private int[] getLongestPrefixSuffix(string s) {
        var n = s.Length;
        var lps = new int[n];
        var idx = 1;
        var lastProperPrefix = 0;

        while (n > idx) {
            if (s[idx] == s[lastProperPrefix]) {
                lps[idx++] = ++lastProperPrefix;
            } else {
                if (0 == lastProperPrefix) {
                    lps[idx++] = lastProperPrefix;
                } else {
                    --lastProperPrefix;
                }
            }
        }

        return lps;
    }

    // Rabin Karp O(n)
    public int StrStrRabinKarp(string haystack, string needle) {
        var n = haystack.Length;
        var l = needle.Length;

        if (n < l) {
            return -1;
        }

        long coefficient = 256;
        long maxCoefficient = 1;
        long MOD = 1000000007;
        long h = 0;
        long ref_h = 0;

        var slidingWindow = new Queue<char>(l);

        for (var i = 0; l > i; ++i) {
            h = (h * coefficient + haystack[i]) % MOD;
            ref_h = (ref_h * coefficient + needle[i]) % MOD;
            maxCoefficient = (maxCoefficient * coefficient) % MOD;
            slidingWindow.Enqueue(haystack[i]);
        }

        if (h == ref_h && needle == string.Join("", slidingWindow)) {
            return 0;
        }

        for (var start = 1; n - l + 1 > start; ++start) {
            h = (h * coefficient - haystack[start - 1] * maxCoefficient + haystack[start + l - 1]) % MOD;

            slidingWindow.Dequeue();
            slidingWindow.Enqueue(haystack[start + l - 1]);

            if (0 > h) {
                h += MOD;
            }

            if (h == ref_h && needle == string.Join("", slidingWindow)) {
                return start;
            }
        }

        return -1;
    }
}
