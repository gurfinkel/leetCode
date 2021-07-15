/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Integer> store = new HashSet<>();

//         while (null != p) {
//             store.add(p.val);
//             p = p.parent;
//         }

//         while (null != q && !store.contains(q.val)) {
//             q = q.parent;
//         }

//         return q;

        while (null != p || null != q) {
            if (null != p) {
                if (store.contains(p.val)) {
                    return p;
                }
                store.add(p.val);
                p = p.parent;
            }

            if (null != q) {
                if (store.contains(q.val)) {
                    return q;
                }
                store.add(q.val);
                q = q.parent;
            }
        }

        return null;
    }
}
