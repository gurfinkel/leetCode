class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Integer, Integer> store = Map.of(0, 0, 1, 1, 6, 9, 8, 8, 9, 6);
        StringBuilder sb = new StringBuilder();

        for (char digit : num.toCharArray()) {
            sb.insert(0, store.get(digit - '0'));
        }

        return num.equals(sb.toString());
    }
}
