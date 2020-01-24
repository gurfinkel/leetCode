/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    const getLps = function(s) {
        const n = s.length;
        const lps = Array(n);

        let index = 1;
        let lastPrefixLength = 0;

        lps[0] = 0;

        while (n > index) {
            if (s[index] === s[lastPrefixLength]) {
                lps[index++] = ++lastPrefixLength;
            } else {
                if (lastPrefixLength) {
                    lastPrefixLength = lps[lastPrefixLength - 1];
                } else {
                    lps[index++] = lastPrefixLength;
                }
            }
        }

        return lps;
    };

    const kmpSearch = function(pattern, text) {
        const result = [];
        const pLength = pattern.length;
        const tLength = text.length;
        const lps = getLps(pattern);

        let pIndex = 0;
        let tIndex = 0;

        while (tLength > tIndex) {
            if (pattern[pIndex] === text[tIndex]) {
                ++pIndex;
                ++tIndex;
            }

            if (pLength === pIndex) {
                result.push(tIndex - pIndex);
                pIndex = lps[pIndex - 1];
            } else if (tLength > tIndex && pattern[pIndex] !== text[tIndex]) {
                if (pIndex) {
                    pIndex = lps[pIndex - 1];
                } else {
                    ++tIndex;
                }
            }
        }

        return result;
    };

    const h = haystack.length;
    const n = needle.length;

    if ((!h && !n) || haystack === needle) {
        return 0;
    }

    if (!h) {
        return -1;
    }

    if (!n) {
        return 0;
    }

    if (n > h) {
        return -1;
    }

    const result = kmpSearch(needle, haystack);

    return result.length ? result[0] : -1;
};
