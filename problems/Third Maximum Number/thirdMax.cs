public class Solution {
    public int ThirdMax(int[] nums) {
        var store = (new HashSet<int>(nums)).ToList();

        if (1 == store.Count) {
            return store[0];
        }

        if (2 == store.Count) {
            return Math.Max(store[0], store[1]);
        }

        var minHeap = new MinHeap();

        for (var i = 0; store.Count > i; ++i) {
            minHeap.Add(store[i]);
            if (3 <= i) {
                minHeap.ExtractTop();
            }
        }

        return minHeap.ExtractTop();
    }

    private class MinHeap {
        private readonly int[] _data = new int[4];
        private int _last = -1;

        public MinHeap() {

        }

        public void Add(int item) {
            _data[++_last] = item;
            SiftUp(_last);
        }

        public int ExtractTop() {
            var top = _data[0];

            _data[0] = _data[_last--];
            SiftDown(0);

            return top;
        }

        private void SiftDown(int i) {
            while (_last >= (i << 1) + 1) {
                var left = (i << 1) + 1;
                var right = (i << 1) + 2;
                var j = left;

                if (_last >= right && _data[left] > _data[right]) {
                    j = right;
                }

                if (_data[i] < _data[j]) {
                    break;
                }

                Swap(i, j);
                i = j;
            }
        }

        private void SiftUp(int i) {
            while (0 < i && _data[i] < _data[(i - 1) >> 1]) {
                Swap(i, (i - 1) >> 1);
                i = (i - 1) >> 1;
            }
        }

        private void Swap(int i, int j) {
            var temp = _data[i];
            _data[i] = _data[j];
            _data[j] = temp;
        }
    }
}
