class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;

        while (arr1.length > idx1 && arr2.length > idx2 && arr3.length > idx3) {
            if (arr1[idx1] == arr2[idx2] && arr2[idx2] == arr3[idx3]) {
                result.add(arr1[idx1]);
                ++idx1;
                ++idx2;
                ++idx3;
            } else if (arr1[idx1] < arr2[idx2] || arr1[idx1] < arr3[idx3]) {
                ++idx1;
            } else if (arr2[idx2] < arr1[idx1] || arr2[idx2] < arr3[idx3]) {
                ++idx2;
            } else if (arr3[idx3] < arr1[idx1] || arr3[idx3] < arr2[idx2]) {
                ++idx3;
            }
        }

        return result;
    }
}
