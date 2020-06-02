/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public IList<IList<int>> VerticalTraversal(TreeNode root) {
        IDictionary<int, List<(int val, int depth)>> vertLevel2Nodes = new Dictionary<int, List<(int val, int depth)>>();
        Helper(root, 0,0, vertLevel2Nodes);

        if (vertLevel2Nodes.Count == 0)
        {
            return new List<IList<int>>();
        }

        foreach (var vertLevel2Node in vertLevel2Nodes)
        {
            vertLevel2Node.Value.Sort((t1, t2) =>
            {
                var depthCmp =  t1.depth.CompareTo(t2.depth);
                if (depthCmp != 0)
                {
                    return depthCmp;
                }

                return t1.val.CompareTo(t2.val);
            });
        }

        var keys = vertLevel2Nodes.Keys.ToArray();
        Array.Sort(keys);

        IList<IList<int>> res = new List<IList<int>>();

        foreach (var key in keys)
        {
            res.Add(new List<int>());
            foreach (var t in vertLevel2Nodes[key])
            {
                res[res.Count - 1].Add(t.val);
            }
        }

        return res;
    }

    private void Helper(TreeNode node, int key, int depth, IDictionary<int, List<(int val, int depth)>> vertLevel2Nodes)
    {
        if (node == null)
        {
            return;
        }

        if (!vertLevel2Nodes.ContainsKey(key))
        {
            vertLevel2Nodes[key] = new List<(int val, int depth)>();
        }
        vertLevel2Nodes[key].Add((node.val, depth));

        Helper(node.left, key - 1, depth + 1, vertLevel2Nodes);
        Helper(node.right, key + 1, depth + 1, vertLevel2Nodes);
    }
}
