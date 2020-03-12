public class Solution {
    public int ShortestDistance(int[][] maze, int[] start, int[] destination) {
        int n = maze.Length;
        int m = maze[0].Length;

        Queue<(int, int)> bfs = new Queue<(int, int)>();
        ISet<(int, int)> visitedCells = new HashSet<(int, int)>();

        bfs.Enqueue((start[0], start[1]));
        visitedCells.Add((start[0], start[1]));
        IDictionary<(int, int), IDictionary<(int,int), int>> graph = new Dictionary<(int, int), IDictionary<(int, int), int>>();

        while (bfs.Count > 0)
        {
            var currentCell = bfs.Dequeue();

            foreach (var direction in _directions)
            {
                var movementCell = currentCell;
                int distance = 0;

                while (true)
                {
                    var nextCell = (movementCell.Item1 + direction.Item1, movementCell.Item2 + direction.Item2);
                    if (nextCell.Item1 < 0 || nextCell.Item1 >= n || nextCell.Item2 < 0 || nextCell.Item2 >= m ||
                        maze[nextCell.Item1][nextCell.Item2] == 1)
                    {
                        break;
                    }

                    distance++;
                    movementCell = nextCell;
                }

                if (visitedCells.Add(movementCell))
                {
                    bfs.Enqueue(movementCell);
                }

                if (!(movementCell.Item1 == currentCell.Item1 && movementCell.Item2 == currentCell.Item2))
                {
                    if (!graph.ContainsKey(currentCell))
                    {
                        graph[currentCell] = new Dictionary<(int, int), int>();
                    }
                    graph[currentCell][movementCell] = distance;
                }
            }
        }

        //dijkstra
        int[,] resultDistances = new int[n,m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                resultDistances[i, j] = int.MaxValue;
            }
        }

        resultDistances[start[0], start[1]] = 0;
        IList<((int,int), int)> data = new List<((int, int), int)>(n * m);

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                data.Add(((i,j), resultDistances[i,j]));
            }
        }

        Heap<((int,int), int)> heap = new Heap<((int, int), int)>(data, new TupleComparer());

        checked
        {
            while (heap.Count > 0)
            {
                var top = heap.ExtractTop();

                //inactual pair
                if (resultDistances[top.Item1.Item1, top.Item1.Item2] != top.Item2)
                {
                    continue;
                }

                if (graph.ContainsKey(top.Item1))
                {
                    foreach (var edge in graph[top.Item1])
                    {
                        var dst = edge.Key;
                        int weight = edge.Value;

                        var possibleWeight = resultDistances[top.Item1.Item1, top.Item1.Item2] + weight;

                        if (possibleWeight < resultDistances[dst.Item1, dst.Item2])
                        {
                            resultDistances[dst.Item1, dst.Item2] = possibleWeight;
                            heap.Add((dst, possibleWeight));
                        }
                    }
                }
            }
        }

        return resultDistances[destination[0], destination[1]] == int.MaxValue ? -1 : resultDistances[destination[0], destination[1]];
    }

    private static readonly (int, int)[] _directions = {(0,1), (0,-1), (1,0), (-1,0)};

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

    private class TupleComparer : IComparer<((int, int), int)>
    {
        public int Compare(((int, int), int) x, ((int, int), int) y) => x.Item2.CompareTo(y.Item2);
    }
}