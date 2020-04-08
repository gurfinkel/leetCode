public class Solution {
    public void NextPermutation(int[] nums) {
        var n = nums.Length - 1;
        var i = n - 1;

        while (0 <= i && nums[1 + i] <= nums[i]) {--i;}

        if (0 <= i) {
            var j = n;

            while (i < j && nums[i] >= nums[j]) {--j;}

            Swap(nums, i, j);
        }

        Reverse(nums, 1 + i, n);
    }

    private void Swap(int[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void Reverse(int[] arr, int i, int j) {
        while (i < j) {
            Swap(arr, i++, j--);
        }
    }
}
