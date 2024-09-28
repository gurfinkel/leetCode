/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }
        
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (null == root.left && null == root.right) {
                root = null;
            } else if (null != root.right) {
                // the node is not a leaf and has a right child
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            } else {
                // the node is not a leaf, has no right child, and has a left child    
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        
        return root;
    }

    /*
    One step right and then always left
    */
    public int successor(TreeNode node) {
        TreeNode nextNode = node.right;

        while (null != nextNode.left) {
            nextNode = nextNode.left;
        }

        return nextNode.val;
    }

    /*
    One step left and then always right
    */
    public int predecessor(TreeNode node) {
        TreeNode nextNode = node.left;

        while (null != nextNode.right) {
            nextNode = nextNode.right;
        }

        return nextNode.val;
    }
}
