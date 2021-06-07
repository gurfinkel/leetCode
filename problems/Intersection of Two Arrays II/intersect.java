class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (nums1.length > idx1 && nums2.length > idx2) {
            if (nums1[idx1] > nums2[idx2]) {
                ++idx2;
            } else if (nums1[idx1] < nums2[idx2]) {
                ++idx1;
            } else {
                result.add(nums1[idx1]);
                ++idx1;
                ++idx2;
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}
