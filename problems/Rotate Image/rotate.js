/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    const len = matrix.length - 1;

    for (let i = 0; 1 + (len >> 1) > i; ++i) {
        for (let j = i; len - i > j; ++j) {
            let tmp = matrix[i][j];
            matrix[i][j] = matrix[len-j][i];
            [matrix[len-j][i], matrix[len-i][len-j]] = [matrix[len-i][len-j], matrix[j][len-i]];
            matrix[j][len-i] = tmp;
        }
    }
};
