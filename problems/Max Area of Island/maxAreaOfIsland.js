/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxAreaOfIsland = function(grid) {
    const rows = grid.length;
    const cols = grid[0].length;
    let maxSize = 0;
    let sizeArray = [];

    const dfs = function(g, r, c) {
        if (0 > r || g.length <= r || 0 > c || g[0].length <= c || 0 === g[r][c]) {
            return;
        }

        g[r][c] = 0;
        ++sizeArray[sizeArray.length - 1];

        dfs(g, r - 1, c);
        dfs(g, 1 + r, c);
        dfs(g, r, c - 1);
        dfs(g, r, 1 + c);
    };

    for (let row = 0; rows > row; ++row) {
        for (let col = 0; cols > col; ++col) {
            if (1 === grid[row][col]) {
                sizeArray.push(0);
                dfs(grid, row, col);
                maxSize = Math.max(maxSize, sizeArray[sizeArray.length - 1]);
            }
        }
    }

    return maxSize;
};
