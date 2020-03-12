public class Solution {
    public int MaximumSwap(int num) {
        IList<int> list = new List<int>();

        while (num > 0)
        {
            list.Add(num % 10);
            num /= 10;
        }

        bool flag = true;

        for (int i = list.Count - 1; i >= 0; i--)
        {
            if (flag)
            {
              var maxIndex = i;

              for (int j = 0; j < i; j++)
                if (list[j] > list[maxIndex]) maxIndex = j;

              if (maxIndex != i)
              {
                flag = false;
                var temp = list[maxIndex];
                list[maxIndex] = list[i];
                list[i] = temp;
              }
            }

            num = num * 10 + list[i];
        }

        return num;
    }
}
