/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    if (!s || !s.length) {
        return '';
    }

    const expandAroundCenter = function(s, left, right) {
        while (0 <= left && s.length > right && s.charAt(left) === s.charAt(right)) {
            --left;
            ++right;
        }

        return right - left - 1;
    }

    let start = 0;
    let end = 0;

    for (let idx = 0; s.length > idx; ++idx) {
        let len1 = expandAroundCenter(s, idx, idx);
        let len2 = expandAroundCenter(s, idx, 1 + idx);
        let len = Math.max(len1, len2);

        if (end - start < len) {
            start = idx - Math.trunc((len - 1) / 2);
            end = idx + Math.trunc(len / 2);
        }
    }

    return s.substring(start, 1 + end);
};
