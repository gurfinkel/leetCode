/**
 * @param {number[]} arr
 * @return {number[]}
 */
var sortByBits = function(arr) {
    const getNumberOfBits = function(n) {
        let result = 0;
        
        while (1 < n) {
            if (1 === (n & 1)) {
                ++result;
            }
            n >>= 1;
        }
        
        return result;
    };
    
    const compareNumbersInBinary = function(a, b) {
        const aNumberOfBits = getNumberOfBits(a);
        const bNumberOfBits = getNumberOfBits(b);
        
        if (aNumberOfBits === bNumberOfBits) {
            return a - b;
        } else {
            return aNumberOfBits - bNumberOfBits;
        }
    };
    
    arr.sort((a, b) => compareNumbersInBinary(a, b));
    
    return arr;
};
