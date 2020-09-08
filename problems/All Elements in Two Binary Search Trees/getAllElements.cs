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
    public IList<int> GetAllElements(TreeNode root1, TreeNode root2) {
        var result = new List<int>();
        var inOrder1 = new List<int>();
        var inOrder2 = new List<int>();
        var idx1 = 0;
        var idx2 = 0;

        fillInOrder(root1, inOrder1);
        fillInOrder(root2, inOrder2);

        while (inOrder1.Count > idx1 || inOrder2.Count > idx2) {
            if (inOrder1.Count == idx1) {
                result.Add(inOrder2[idx2++]);
            } else if (inOrder2.Count == idx2) {
                result.Add(inOrder1[idx1++]);
            } else {
                if (inOrder1[idx1] < inOrder2[idx2]) {
                    result.Add(inOrder1[idx1++]);
                } else {
                    result.Add(inOrder2[idx2++]);
                }
            }
        }

        return result;
    }

    private void fillInOrder(TreeNode node, List<int> inOrder) {
        if (null == node) {
            return;
        }

        fillInOrder(node.left, inOrder);
        inOrder.Add(node.val);
        fillInOrder(node.right, inOrder);
    }
}
