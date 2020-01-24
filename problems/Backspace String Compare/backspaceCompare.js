/**
 * @param {string} S
 * @param {string} T
 * @return {boolean}
 */
var backspaceCompare = function(S, T) {
    let sIndex = S.length - 1;
    let tIndex = T.length - 1;
    let sBackspace = 0;
    let tBackspace = 0;

    while (0 <= sIndex || 0 <= tIndex) {
        if ('#' === S[sIndex]) {
            ++sBackspace;
            --sIndex;
        } else if ('#' === T[tIndex]) {
            ++tBackspace;
            --tIndex;
        } else {
            if (sBackspace) {
                --sBackspace;
                --sIndex;
            } else if (tBackspace) {
                --tBackspace;
                --tIndex;
            } else {
                if (S[sIndex] === T[tIndex]) {
                    --sIndex;
                    --tIndex;
                } else {
                    return false;
                }
            }
        }
    }

    return true;
};
