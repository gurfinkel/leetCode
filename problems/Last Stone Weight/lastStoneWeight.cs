public class Solution {
    public int LastStoneWeight(int[] stones) {
        var result = 0;

        var maxHeap = new MaxHeap();
        var temp = new List<int>();

        foreach (var item in stones) {
            maxHeap.add(item);
        }

        result = maxHeap.extractTop();
        while (0 < maxHeap.size()) {
            var stone = maxHeap.extractTop();
            if (result != stone) {
                maxHeap.add(Math.Abs(result - stone));
            }
            result = 0 == maxHeap.size() ? 0 : maxHeap.extractTop();
        }

        return result;
    }

    private class MaxHeap {
        private readonly List<int> _data = new List<int>();

        public void add(int item) {
            _data.Add(item);
            siftUp(_data.Count - 1);
        }

        public int extractTop() {
            var top = _data[0];

            _data[0] = _data[_data.Count - 1];
            _data.RemoveAt(_data.Count - 1);
            siftDown(0);

            return top;
        }

        public int size() {
            return _data.Count;
        }

        private void siftDown(int i) {
            while (_data.Count > (i << 1) + 1) {
                var left = (i << 1) + 1;
                var right = (i << 1) + 2;
                var j = left;

                if (_data.Count > right && _data[left] < _data[right]) {
                    j = right;
                }

                if (_data[i] > _data[j]) {
                    break;
                }

                swap(i, j);
                i = j;
            }
        }

        private void siftUp(int i) {
            while (0 < i && _data[i] > _data[(i - 1) >> 1]) {
                swap(i, (i - 1) >> 1);
                i = (i - 1) >> 1;
            }
        }

        private void swap(int i, int j) {
            var temp = _data[i];
            _data[i] = _data[j];
            _data[j] = temp;
        }
    }
}
