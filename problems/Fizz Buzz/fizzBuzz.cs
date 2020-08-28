public class Solution {
    public IList<string> FizzBuzz(int n) {
        var result = new List<string>();

        for (var idx = 1; n >= idx; ++idx) {
            if (0 == idx % 3 && 0 == idx % 5) {
                result.Add("FizzBuzz");
            } else if (0 == idx % 3) {
                result.Add("Fizz");
            } else if (0 == idx % 5) {
                result.Add("Buzz");
            } else {
                result.Add(idx.ToString());
            }
        }

        return result;
    }
}
