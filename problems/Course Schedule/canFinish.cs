public class Solution {
    // Topology Sort
    public bool CanFinish(int numCourses, int[][] prerequisites) {
        int[] incoming = new int[numCourses];
        var graph = new List<int>[numCourses];
        var visited = new HashSet<int>();
        foreach(int[] pre in prerequisites)
        {
            int current = pre[0];
            int prereq = pre[1];
            incoming[current]++;
            if(graph[prereq] == null)
                graph[prereq] = new List<int>();
            graph[prereq].Add(current);
        }

        var zeroPrereqCourses = FindZeroCount(incoming, visited);

        while(zeroPrereqCourses.Count > 0)
        {
            var temp = new List<int>();
            foreach(var cur in zeroPrereqCourses)
            {
                visited.Add(cur);

                if(visited.Count == numCourses)
                    return true;

                var neighbors = graph[cur];

                if(neighbors == null)
                    continue;

                foreach(var neighbor in neighbors)
                {
                    incoming[neighbor]--;
                    if(incoming[neighbor] == 0)
                        temp.Add(neighbor);
                }
            }

            zeroPrereqCourses = temp;
        }

        return visited.Count == numCourses;
    }

    private List<int> FindZeroCount(int[] arr, HashSet<int> visited)
    {
        var result = new List<int>();

        for(int i = 0; i < arr.Length; i++)
        {
            if(!visited.Contains(i) && arr[i] == 0)
                result.Add(i);
        }
        return result;
    }
}
