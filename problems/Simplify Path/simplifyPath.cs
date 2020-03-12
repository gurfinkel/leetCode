public class Solution {
    public string SimplifyPath(string path) {
        StringBuilder res = new StringBuilder();
        string[] arr = path.Trim('/').Split('/');
        Stack<string> dirs = new Stack<string>();

        foreach (var s in arr)
        {
            if (s.Length == 0)
            {
                continue;
            }

            if (s == ".")
            {
                continue;
            }

            if (s == "..")
            {
                if (dirs.Count > 0)
                {
                    dirs.Pop();
                }
                continue;
            }

            dirs.Push(s);
        }

        if (dirs.Count == 0)
        {
            res.Append('/');
        }
        else
        {
            Stack<string> reverseStack = new Stack<string>();
            while (dirs.Count > 0)
            {
                reverseStack.Push(dirs.Pop());
            }

            while (reverseStack.Count > 0)
            {
                res.Append('/');
                res.Append(reverseStack.Pop());
            }
        }

        return res.ToString();
    }
}
