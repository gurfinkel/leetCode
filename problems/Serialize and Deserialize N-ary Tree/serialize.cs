/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, IList<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/
public class Codec {

    // Encodes a tree to a single string.
    public string serialize(Node root) {
        if(root == null)
        {
            return null;
        }

        IList<string> sb = new List<string>();
        SerializeHelper(root, sb);

        return string.Join(";", sb.ToArray());
    }

    // Decodes your encoded data to tree.
    public Node deserialize(string data) {
        if(string.IsNullOrEmpty(data))
        {
            return null;
        }

        string[] items = data.Split(';');

        Queue<string> q = new Queue<string>(items);


        return DeserializeHelper(q);
    }

    void SerializeHelper(Node root, IList<string> sb)
    {
        if(root == null)
        {
            return;
        }

        sb.Add(root.val.ToString());
        sb.Add(root.children.Count.ToString());

        for(int i = 0; i < root.children.Count; i ++)
        {
            SerializeHelper(root.children[i], sb);
        }
    }

    Node DeserializeHelper(Queue<string> q)
    {
        Node n = new Node();
        n.val = int.Parse(q.Dequeue());

        int count = int.Parse(q.Dequeue());
        n.children = new List<Node>(count);

        for(int i = 0; i < count; i++)
        {
            n.children.Add(DeserializeHelper(q));
        }

        return n;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
