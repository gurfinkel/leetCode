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
    private void serializeTree(TreeNode node, List<string> str) {
        if (null == node) {
            str.Add("null");
        } else {
            str.Add(node.val.ToString());
            serializeTree(node.left, str);
            serializeTree(node.right, str);
        }
    }

    private TreeNode deserializeTree(List<string> str) {
        if ("null".Equals(str[0])) {
            str.RemoveAt(0);
            return null;
        }

        var node = new TreeNode(int.Parse(str[0]));
        str.RemoveAt(0);
        node.left = deserializeTree(str);
        node.right = deserializeTree(str);

        return node;
    }

    // Encodes a tree to a single string.
    public string serialize(TreeNode root) {
        var treeAsString = new List<string>();

        serializeTree(root, treeAsString);

        return string.Join(",", treeAsString);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(string data) {
        return deserializeTree(data.Split(",").ToList());
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
