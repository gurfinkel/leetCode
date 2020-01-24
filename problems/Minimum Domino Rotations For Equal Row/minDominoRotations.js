/**
 * @param {number[]} A
 * @param {number[]} B
 * @return {number}
 */
var minDominoRotations = function(A, B) {
    const n = A.length;
    let rotations = [0, 1, 0, 1];

    for (let i = 1; n > i; ++i) {
        if (~rotations[0] && A[0] !== A[i]) {
            if (A[0] === B[i]) {
                ++rotations[0];
            } else {
                rotations[0] = -1;
            }
        }

        if (~rotations[1] && A[0] !== B[i]) {
            if (A[0] === A[i]) {
                ++rotations[1];
            } else {
                rotations[1] = -1;
            }
        }

        if (~rotations[2] && B[0] !== B[i]) {
            if (B[0] === A[i]) {
                ++rotations[2];
            } else {
                rotations[2] = -1;
            }
        }

        if (~rotations[3] && B[0] !== A[i]) {
            if (B[0] === B[i]) {
                ++rotations[3];
            } else {
                rotations[3] = -1;
            }
        }

        if (!~Math.max(...rotations)) {
            break;
        }
    }

    const result = rotations.filter(item => ~item);

    return result.length ? Math.min(...result) : -1;
};
