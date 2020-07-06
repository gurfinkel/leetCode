public class Solution {
    public int[] PlusOne(int[] digits) {
        List<int> result = new List<int>();
        int memory = 1;
        int idx = digits.Length;

        while (0 <= --idx || 1 == memory) {
            int digit = memory + (0 <= idx ? digits[idx] : 0);

            result.Insert(0, digit % 10);
            memory = digit / 10;
        }

        return result.ToArray();
    }
}
