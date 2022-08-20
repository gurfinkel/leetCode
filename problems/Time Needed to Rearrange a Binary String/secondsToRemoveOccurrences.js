/**
 * @param {string} s
 * @return {number}
 */
var secondsToRemoveOccurrences = function(s) {
    let result = 0;
    let counter = (s.match(/01/g) || []).length;

    while (0 < counter) {
        s = s.replace(/01/g, '10');
        counter = (s.match(/01/g) || []).length;
        ++result;
    }

    return result;
};
