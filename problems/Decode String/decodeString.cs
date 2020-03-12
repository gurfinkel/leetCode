public class Solution {
    public string DecodeString(string s) {
        _input = s;
        return Helper(0, out _);
    }

    private string _input;

    private string Helper(int start, out int next)
    {
        int cur = start;
        int repeat = 0;
        StringBuilder sb = new StringBuilder();

        while (true)
        {
            if (cur >= _input.Length)
            {
                next = cur;
                return sb.ToString();
            }

            char c = _input[cur];
            int num = c - '0';

            if (num >= 0 && num <= 9)
            {
                repeat *= 10;
                repeat += num;
                cur++;
                continue;
            }

            if (c == '[')
            {
                string inner = Helper(cur + 1, out cur);
                for (int i = 0; i < repeat; i++)
                {
                    sb.Append(inner);
                }
                repeat = 0;
                continue;
            }


            if (c == ']')
            {
                next = cur + 1;
                return sb.ToString();
            }

            sb.Append(c);
            cur++;
        }
    }
}
