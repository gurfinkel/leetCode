public class Solution {
    public string GetPermutation(int n, int k) {
        var factorials = new int[n];
        var nums = new List<int> {1};

        factorials[0] = 1;

        for (var i = 1; n > i; ++i) {
          // generate factorial system bases 0!, 1!, ..., (n - 1)!
          factorials[i] = factorials[i - 1] * i;
          // generate nums 1, 2, ..., n
          nums.Add(i + 1);
        }

        // fit k in the interval 0 ... (n! - 1)
        --k;

        // compute factorial representation of k
        var sb = new StringBuilder();

        for (int i = n - 1; -1 < i; --i) {
          if (0 != factorials[i]) {
              var idx = k / factorials[i];
              k -= idx * factorials[i];

              sb.Append(nums[idx]);
              nums.RemoveAt(idx);
          }
        }

        return sb.ToString();
    }
}
