private class MinComparer : IComparer<int>
{
    public int Compare(int x, int y) => x.CompareTo(y);
}

private class MaxComparer : IComparer<int>
{
    public int Compare(int x, int y) => y.CompareTo(x);
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
