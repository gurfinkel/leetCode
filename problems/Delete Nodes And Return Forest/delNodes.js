/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number[]} to_delete
 * @return {TreeNode[]}
 */
var delNodes = function(root, to_delete) {
    const result = [];
    const store = new Set(to_delete);

    if (!store.has(root.val)) {
        result.push(root);
    }

    const dfs = function(node, parent) {
        if (!node) {
            return;
        }

        if (store.has(node.val)) {
            if (parent) {
                if (parent.left === node) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }

            if (node.left && !store.has(node.left.val)) {
                result.push(node.left);
            }
            if (node.right && !store.has(node.right.val)) {
                result.push(node.right);
            }
        }

        dfs(node.left, node);
        dfs(node.right, node);
    };

    dfs(root);

    return result;
};
