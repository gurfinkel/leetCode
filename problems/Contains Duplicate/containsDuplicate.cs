public class Solution {
    public bool ContainsDuplicate(int[] nums) {
        var store = new HashSet<int>(nums);
        return store.Count != nums.Length;
    }
}
