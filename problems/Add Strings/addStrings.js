/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var addStrings = function(num1, num2) {
    const result = [];
    const zeroCode = '0'.charCodeAt();
    let idx1 = num1.length - 1;
    let idx2 = num2.length - 1;
    let carry = 0;

    while (0 <= idx1 || 0 <= idx2 || 0 !== carry) {
        let sum = carry;

        if (0 <= idx1) {
            sum += num1.charCodeAt(idx1--) - zeroCode;
        }

        if (0 <= idx2) {
            sum += num2.charCodeAt(idx2--) - zeroCode;
        }

        result.push(sum % 10);
        carry = Math.floor(sum / 10);
    }

    result.reverse();

    return result.join('');
};
