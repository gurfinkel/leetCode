/**
 * @param {string} s
 * @return {string}
 */
var removeDuplicates = function(s) {
    const sb = [];

    for (const letter of s) {
        if (0 === sb.length || sb[sb.length - 1] !== letter) {
            sb.push(letter);
        } else {
            sb.splice(sb.length - 1, 1);
        }
    }

    return sb.join('');
};
