public class Solution {
    public int[] FindOrder(int numCourses, int[][] prerequisites) {
        // map :: key=course; value=list of courses that have the key as a pre-req
        List<int>[] map = new List<int>[numCourses];
        for (int i = 0; i < numCourses; i++) map[i] = new List<int>();

        // count number of pre-reqs for each course
        int[] cnts = new int[numCourses];

        // build graph and counts
        for (int i = 0; i < prerequisites.GetLength(0); i++)
        {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            map[pre].Add(course);
            cnts[course]++;
        }

        // enqueue all course which have no pre-reqs
        Queue<int> queue = new Queue<int>();
        for (int i = 0; i < numCourses; i++) if (cnts[i] == 0) queue.Enqueue(i);

        // no starting point - cycle(s)
        if (queue.Count == 0) return new int[0];

        // track visited - only visit once
        bool[] visited = new bool[numCourses];

        // add to list on each first visit
        int[] order = new int[numCourses];
        int orderIndex = 0;

        // when unvisited decriment each child's count
        // if that child already has zero count -> cycle
        // if that child has zero count after deduction then enque this node
        while(queue.Count > 0)
        {
            int i = queue.Dequeue();
            if (!visited[i])
            {
                visited[i] = true;
                order[orderIndex++] = i;
                foreach (int x in map[i])
                {
                    if (cnts[x] == 0) return new int[0]; // cycle
                    cnts[x]--;
                    if (cnts[x] == 0) queue.Enqueue(x);
                }
            }
        }

        // if not all courses were added there were pre-reqs that could not be removed (cycle)
        return orderIndex < numCourses ? new int[0] : order;
    }
}
