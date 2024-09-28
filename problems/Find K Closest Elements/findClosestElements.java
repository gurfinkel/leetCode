class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>(k);
        int left = 0;
		int right = arr.length - 1;

		while (k <= right - left) {
			if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
				++left;
			} else {
				--right;
			}
		}
		
		for (int idx = left; right >= idx; ++idx) {
			result.add(arr[idx]);
		}
        
		return result;
    }
}
