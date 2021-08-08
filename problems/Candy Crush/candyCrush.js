/**
 * @param {number[][]} board
 * @return {number[][]}
 */
var candyCrush = function(board) {
    const minCount = 3;
    const rows = board.length;
    const cols = board[0].length;
    let hasFinished = true;

    for (let row = 0; rows > row; ++row) {
        let count = 1;

        for (let col = 1; cols > col; ++col) {
            const val = Math.abs(board[row][col - 1]);

            if (0 != val && Math.abs(board[row][col]) == val) {
                ++count
            } else {
                if (minCount <= count) {
                    hasFinished = false;

                    while (0 < count) {
                        board[row][col - count] = -val;
                        --count;
                    }
                }
                count = 1;
            }
        }

        if (minCount <= count) {
            hasFinished = false;

            const val = Math.abs(board[row][cols - count]);

            while (0 < count) {
                board[row][cols - count] = -val;
                --count;
            }
        }
    }

    for (let col = 0; cols > col; ++col) {
        let count = 1;

        for (let row = 1; rows > row; ++row) {
            const val = Math.abs(board[row - 1][col]);

            if (0 != val && Math.abs(board[row][col]) == val) {
                ++count
            } else {
                if (minCount <= count) {
                    hasFinished = false;

                    while (0 < count) {
                        board[row - count][col] = -val;
                        --count;
                    }
                }
                count = 1;
            }
        }

        if (minCount <= count) {
            hasFinished = false;

            const val = Math.abs(board[rows - count][col]);

            while (0 < count) {
                board[rows - count][col] = -val;
                --count;
            }
        }
    }

    for (let col = 0; cols > col; ++col) {
        let idx = rows - 1;

        for (let row = rows - 1; 0 <= row; --row) {
            if (0 < board[row][col]) {
                board[idx][col] = board[row][col];

                if (idx != row) {
                    board[row][col] = 0;
                }

                --idx;
            } else {
                board[row][col] = 0;
            }
        }
    }

    return hasFinished ? board : candyCrush(board);
};
