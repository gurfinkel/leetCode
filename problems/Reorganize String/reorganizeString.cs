public class Solution {
    public string ReorganizeString(string S) {
        IDictionary<char, int> char2Count = new Dictionary<char, int>();
        foreach (var c in S)
        {
            if (!char2Count.ContainsKey(c))
            {
                char2Count[c] = 0;
            }

            char2Count[c]++;
        }

        Heap<char> heap = new Heap<char>(char2Count.Keys.ToList(), new CharComparer(char2Count));
        StringBuilder res = new StringBuilder(S.Length);
        IList<char> tmp = new List<char>();

        while (res.Length != S.Length)
        {
            tmp.Clear();

            while (heap.Count > 0 && res.Length > 0 && (heap.Top == res[res.Length - 1] || char2Count[heap.Top] == 0))
            {
                tmp.Add(heap.ExtractTop());
            }

            if (heap.Count == 0)
            {
                return string.Empty;
            }

            var currentChar = heap.ExtractTop();
            char2Count[currentChar]--;
            res.Append(currentChar);

            if (char2Count[currentChar] > 0)
            {
                heap.Add(currentChar);
            }

            foreach (var c in tmp)
            {
                if (char2Count[c] > 0)
                {
                    heap.Add(c);
                }
            }
        }

        return res.ToString();
    }

    private class Heap<T>
    {
        private readonly IList<T> _data;
        private readonly IComparer<T> _comparer;

        public int Count => _data.Count;
        public T Top => _data[0];

        public Heap(IList<T> inputs, IComparer<T> comparer = null)
        {
            _comparer = comparer ?? Comparer<T>.Default;
            _data = inputs;
            for (int i = Count / 2; i >= 0; i--)
            {
                SiftDown(i);
            }
        }

        public Heap(IEnumerable<T> inputs, IComparer<T> comparer = null) : this(inputs.ToList(), comparer)
        {
        }

        private void Swap(int i, int j)
        {
            var tmp = _data[i];
            _data[i] = _data[j];
            _data[j] = tmp;
        }

        private void SiftDown(int i)
        {
            while (2 * i + 1 < _data.Count)
            {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int j = left;

                if (right < _data.Count && _comparer.Compare(_data[right], _data[left]) < 0)
                {
                    j = right;
                }

                if (_comparer.Compare(_data[i], _data[j]) <= 0)
                {
                    break;
                }

                Swap(i, j);
                i = j;
            }
        }

        private void SiftUp(int i)
        {
            while (_comparer.Compare(_data[i], _data[(i - 1) / 2]) < 0)
            {
                Swap(i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        public T ExtractTop()
        {
            T top = Top;
            _data[0] = _data.Last();
            _data.RemoveAt(Count - 1);
            SiftDown(0);
            return top;
        }

        public void Add(T value)
        {
            _data.Add(value);
            SiftUp(Count - 1);
        }
    }

    private class CharComparer : IComparer<char>
    {
        private readonly IDictionary<char, int> _char2Count;

        public CharComparer(IDictionary<char, int> char2Count)
        {
            _char2Count = char2Count;
        }

        public int Compare(char x, char y) => _char2Count[y].CompareTo(_char2Count[x]);
    }
}
