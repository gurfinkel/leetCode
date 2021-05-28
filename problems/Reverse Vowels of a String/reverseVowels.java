class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] arr = s.toCharArray();
		int i = 0;
		int j = arr.length - 1;

		while (i <= j) {
			if (vowels.contains(arr[i]) && vowels.contains(arr[j])) {
				swap(arr, i, j);
				++i;
				--j;
			} else if (vowels.contains(arr[i])) {
				--j;
			} else {
				++i;
			}
		}

		return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
