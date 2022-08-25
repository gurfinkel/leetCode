/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    if (0 > x) {
        return false;
    }

    const digits = [];

    while (x) {
        digits.push(x%10);
        x = Math.trunc(x/10);
    }

    let left = 0;
    let right = digits.length - 1;

    while (left < right) {
        if (digits[left++] !== digits[right--]) {
            return false;
        }
    }

    return true;
};
