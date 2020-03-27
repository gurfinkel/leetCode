public class NumArray {

    public NumArray(int[] nums) {
        var n = nums.Length;
        _sums = new int[1 + n];

        for (var i = 0; n > i; ++i) {
            _sums[1 + i] = _sums[i] + nums[i];
        }
    }

    public int SumRange(int i, int j) {
        return _sums[1 + j] - _sums[i];
    }

    private readonly int[] _sums;
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.SumRange(i,j);
 */
