public class Solution {
    public IList<int> TopKFrequent(int[] nums, int k) {
        IDictionary<int, int> val2Count = new Dictionary<int, int>();
        for (int i = 0; i < nums.Length; i++)
        {
            if (!val2Count.ContainsKey(nums[i]))
            {
                val2Count[nums[i]] = 0;
            }

            val2Count[nums[i]]++;
        }

        (int, int)[] val2CountsArr = val2Count.Select(p => (p.Key, p.Value)).ToArray();
        return Helper(val2CountsArr, 0, val2CountsArr.Length - 1, k);
    }

    private int Partition((int, int)[] arr, int l, int r)
    {
        var x = arr[r];
        int i = l;
        (int, int) temp;
        for (int j = l; j <= r - 1; j++)
        {

            if (arr[j].Item2 >= x.Item2)
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }

        temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;

        return i;
    }

    private IList<int> Helper((int, int)[] arr, int l, int r, int k)
    {
        if (k > 0 && k <= r - l + 1)
        {
            int pos = Partition(arr, l, r);
            if (pos - l == k - 1)
            {
                return arr.Take(pos + 1).Select(tuple => tuple.Item1).ToList();
            }

            if (pos - l > k - 1)
            {
                return Helper(arr, l, pos - 1, k);
            }

            return Helper(arr, pos + 1, r, k - pos + l - 1);
        }

        return null;
    }
}
