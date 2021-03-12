/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> preOrder = new ArrayList<>();

        fillPreOrder(root, preOrder);
        System.out.println(String.join(",", preOrder));
        return String.join(",", preOrder);
    }

    private void fillPreOrder(TreeNode node, List<String> preOrder) {
        if (null == node) {
            preOrder.add("null");
        } else {
            preOrder.add("" + node.val);
            fillPreOrder(node.left, preOrder);
            fillPreOrder(node.right, preOrder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> preOrder = new LinkedList<>(Arrays.asList(data.split(",")));

        return getTreeNode(preOrder);
    }

    private TreeNode getTreeNode(Queue<String> preOrder) {
        if ("null".equals(preOrder.peek())) {
            preOrder.poll();
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(preOrder.poll()));

            node.left = getTreeNode(preOrder);
            node.right = getTreeNode(preOrder);

            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
