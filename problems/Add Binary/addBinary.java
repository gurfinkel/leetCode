class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        int memory = 0;

        while (0 <= aIdx || 0 <= bIdx || 1 == memory) {
            int digit = memory;
            digit += (0 <= aIdx && '1' == a.charAt(aIdx--) ? 1 : 0);
            digit += (0 <= bIdx && '1' == b.charAt(bIdx--) ? 1 : 0);

            sb.insert(0, digit % 2);
            memory = digit >> 1;
        }

        return sb.toString();
    }
}
