class Solution {
    public int compareVersion(String version1, String version2) {
        String[] items1 = version1.split("\\.");
        String[] items2 = version2.split("\\.");
        int idx1 = 0;
        int idx2 = 0;

        while (items1.length > idx1 || items2.length > idx2) {
            int num1 = items1.length > idx1 ? parseInt(items1[idx1++]) : 0;
            int num2 = items2.length > idx2 ? parseInt(items2[idx2++]) : 0;

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }

        return 0;
    }

    int parseInt(String s) {
        int num = 0;
        int idx = 0;

        while (s.length() > idx) {
            num *= 10;
            num += s.charAt(idx++) - '0';
        }

        return num;
    }
}
