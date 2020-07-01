/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var countNodes = function(root) {
    const getDepth = function(node) {
        let result = 0;
        while (node.left) {
            node = node.left;
            ++result;
        }
        return result;
    };

    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // Return True if last level node idx exists.
    // Binary search with O(d) complexity.
    const exists = function(idx, node) {
        let left = 0;
        let right = 2**depth - 1;

        for (let i = 0; depth > i; ++i) {
            let pivot = left + ((right - left) >> 1);
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }

        return node !== null;
    };

    // if the tree is empty
    if (!root) {
        return 0;
    }

    let depth = getDepth(root);
    // if the tree contains 1 node
    if (!depth) {
        return 1;
    }

    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // Perform binary search to check how many nodes exist.
    let left = 1;
    let right = 2**depth - 1;

    while (left <= right) {
        let pivot = left + ((right - left) >> 1);
        if (exists(pivot, root)) {
            left = pivot + 1;
        } else {
            right = pivot - 1;
        }
    }

    // The tree contains 2**d - 1 nodes on the first (d - 1) levels
    // and left nodes on the last level.
    return 2**depth - 1 + left;
};
