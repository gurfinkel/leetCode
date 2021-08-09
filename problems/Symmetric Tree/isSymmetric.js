/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function(root) {
    const bfs = [];

    bfs.push(root);

    while (bfs.length) {
        const size = bfs.length;
        const level = [];

        for (let idx = 0; size > idx; ++idx) {
            const node = bfs.shift();

            if (node) {
                level.push(node.val);
                bfs.push(node.left);
                bfs.push(node.right);
            } else {
                level.push('null');
            }
        }

        if (!isPalindrome(level)) {
            return false;
        }
    }

    return true;
};

const isPalindrome = function(a) {
    const n = a.length;

    for (let idx = 0; n / 2 > idx; ++idx) {
        if (a[idx] !== a[n - 1 - idx]) {
            return false;
        }
    }

    return true;
}
