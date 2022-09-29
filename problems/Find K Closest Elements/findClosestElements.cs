public class Solution {
    public IList<int> FindClosestElements(int[] arr, int k, int x) {
        int idx = Array.BinarySearch(arr, x);
        LinkedList<int> ll = new LinkedList<int>();
        int l = 0;
        int r = 0;

        if (idx >= 0) {
            ll.AddLast(arr[idx]);
            l = idx - 1;
            r = idx + 1;
        } else {
            idx++;
            idx = -idx;
            r = idx;
            l = idx - 1;
        }

        for (int i = r; i < arr.Length && ll.Count != k; i++) {
            ll.AddLast(arr[i]);
        }


        for (int i = l; i >= 0; i--) {
            ll.AddFirst(arr[i]);

            if (ll.Count > k) {
                LinkedListNode<int> farthest = ll.First;

                if (Math.Abs(ll.Last.Value - x) >= Math.Abs(ll.First.Value - x)) {
                    farthest = ll.Last;
                }

                ll.Remove(farthest);
            }
        }

        return ll.ToList();
    }
}
