/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public bool IsSameTree(TreeNode p, TreeNode q) {
        var serializeP = serializeTree(p);
        var serializeQ = serializeTree(q);

        return String.Equals(serializeP, serializeQ);
    }

    private String serializeTree(TreeNode node) {
        var preOrder = new List<string>();

        fillPreOrder(node, preOrder);

        return String.Join(", ", preOrder);
    }

    private void fillPreOrder(TreeNode node, List<string> preOrder) {
        if (null == node) {
            preOrder.Add("null");
        } else {
            preOrder.Add(node.val.ToString());
            fillPreOrder(node.left, preOrder);
            fillPreOrder(node.right, preOrder);
        }
    }
}
