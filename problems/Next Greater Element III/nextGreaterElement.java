class Solution {
    public int nextGreaterElement(int n) {
        char[] a = ("" + n).toCharArray();
        int i = a.length - 2;
        int j = a.length - 1;

        while (0 <= i && a[1 + i] <= a[i]) {
            --i;
        }

        if (0 > i) {
            return -1;
        }

        while (0 <= j && a[j] <= a[i]) {
            --j;
        }

        swap(a, i, j);
        reverse(a, 1 + i);

        try {
            return Integer.parseInt(new String(a));
        } catch (Exception e) {
            return -1;
        }
    }

    private void reverse(char[] a, int start) {
        int i = start;
        int j = a.length - 1;

        while (i < j) {
            swap(a, i++, j--);
        }
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
