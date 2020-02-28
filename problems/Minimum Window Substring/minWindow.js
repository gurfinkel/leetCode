/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    if (!s.length || !t.length) {
        return '';
    }

    // Dictionary which keeps a count of all the unique characters in t.
    const dictT = {};
    for (let i = 0; t.length > i; ++i) {
        let count = dictT[t[i]] ? dictT[t[i]] : 0;
        dictT[t[i]] = count + 1;
    }

    // Number of unique characters in t,
    // which need to be present in the desired window.
    let required = Object.keys(dictT).length;

    // Left and Right pointer
    let l = 0;
    let r = 0;

    // formed is used to keep track of how many unique characters in t
    // are present in the current window in its desired frequency.
    // e.g. if t is "AABC" then the window must have two A's, one B and one C.
    // Thus formed would be = 3 when all these conditions are met.
    let formed = 0;

    // Dictionary which keeps a count of all the unique characters in the current window.
    const windowCounts = {};

    // ans list of the form (window length, left, right)
    const ans = [-1, 0, 0];

    while (r < s.length) {
        // Add one character from the right to the window
        let c = s.charAt(r);
        let count = windowCounts[c] ? windowCounts[c] : 0;
        windowCounts[c] = count + 1;

        // If the frequency of the current character added equals to the
        // desired count in t then increment the formed count by 1.
        if (dictT[c] && windowCounts[c] === dictT[c]) {
            formed++;
        }

        // Try and contract the window till the point where it ceases to be 'desirable'.
        while (l <= r && formed === required) {
            c = s.charAt(l);
            // Save the smallest window until now.
            if (-1 === ans[0] || 1 + r - l < ans[0]) {
                ans[0] = 1 + r - l;
                ans[1] = l;
                ans[2] = r;
            }

            // The character at the position pointed by the
            // `Left` pointer is no longer a part of the window.
            windowCounts[c] = windowCounts[c] - 1;
            if (dictT[c] && +windowCounts[c] < +dictT[c]) {
                formed--;
            }

            // Move the left pointer ahead, this would help to look for a new window.
            l++;
        }

        // Keep expanding the window once we are done contracting.
        r++;
    }

    return -1 === ans[0] ? '' : s.substring(ans[1], ans[2] + 1);
};