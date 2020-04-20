/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public string serialize(TreeNode root) {
        var store = new List<string>();

        serializeTree(root, store);

        return string.Join(",", store);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(string data) {
        var store = new Queue<string>(data.Split(","));

        return deserializeTree(store);
    }

    private void serializeTree(TreeNode node, List<string> store) {
        if (null == node) {
            store.Add("null");
        } else {
            store.Add(node.val.ToString());
            serializeTree(node.left, store);
            serializeTree(node.right, store);
        }
    }

    private TreeNode deserializeTree(Queue<string> data) {
        if ("null" == data.Peek()) {
            data.Dequeue();
            return null;
        } else {
            var node = new TreeNode(int.Parse(data.Dequeue()));
            node.left = deserializeTree(data);
            node.right = deserializeTree(data);

            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));