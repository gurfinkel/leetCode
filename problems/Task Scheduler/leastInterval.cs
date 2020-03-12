public class Solution {
    public int LeastInterval(char[] tasks, int n) {
        var map = new int[26];

        foreach (var task in tasks)
            ++map[task - 'A'];

        Array.Sort(map);

        var max_val = map[25] - 1;
        var idle_slots = max_val * n;

        for (var i = 24; 0 <= i && 0 < map[i]; --i) {
            idle_slots -= Math.Min(map[i], max_val);
        }

        return 0 < idle_slots ? idle_slots + tasks.Length : tasks.Length;
    }
}
