/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode MergeKLists(ListNode[] lists) {
        // create heap, add heads of all lists
        // extract head, save for return
        // while heap has count > 0
        // extract node, add to return list, and insert the next node if not null
        var minHeap = new MinHeap();
        minHeap.Heapify(lists);
        var head = minHeap.Extract();
        var curNode = head;
        if (curNode != null && curNode.next != null) minHeap.Insert(curNode.next);
        while(minHeap.Count > 0) {
            var node = minHeap.Extract();
            curNode.next = node;
            curNode = node;
            if (node.next != null)  minHeap.Insert(node.next);
        }
        return head;
    }

    public interface IHeap<T> {
        void Insert(T val);
        T Peek();
        T Extract();
        void Heapify(IList<T> list);
    }

    internal class MinHeap : IHeap<ListNode>{
        IList<ListNode> list;
        int head = 1;
        public MinHeap() {
            // Start list with one default entry to have 1-indexing to support child indexing 2*i,2*i+1
            list = new List<ListNode>{default(ListNode)};
        }
        private int getParent(int i) {
            return i/2;
        }
        private int getLeftChild(int i) {
            return i*2;
        }
        private int getRightChild(int i) {
            return i*2+1;
        }
        public int Count {
            get {
                return list.Count-1;
            }
        }
        public void Insert(ListNode node) {
            list.Add(node);
            var i = this.Count;
            // trickle up
            var p = getParent(i);
            while(i!=head && list[i].val < list[p].val) {
                var temp = list[p];
                list[p] = list[i];
                list[i] = temp;
                i = getParent(i);
                p = getParent(i);
            }
        }
        public ListNode Peek() {
            if(list.Count == head) return default(ListNode);

            return list[head];
        }
        public ListNode Extract() {
            var extracted = Peek();
            if (extracted == null) return extracted;

            list[head] = list[list.Count-1];
            list.RemoveAt(list.Count-1);
            var i = head;
            // trickle down, swap with smallest child
            while(i!=list.Count-1) {
                var swap = i;
                var l = getLeftChild(i);
                if (l<list.Count && list[l].val < list[swap].val) {
                    swap = l;
                }
                var r = getRightChild(i);
                if (r<list.Count && list[r].val < list[swap].val) {
                    swap = r;
                }
                // no swaps, done
                if (swap==i) {
                    break;
                }
                var temp = list[i];
                list[i] = list[swap];
                list[swap] = temp;
                i = swap;
            }

            return extracted;
        }
        public void Heapify(IList<ListNode> list) {
            foreach(var node in list) {
                if(node != null) Insert(node);
            }
        }
    }
}
