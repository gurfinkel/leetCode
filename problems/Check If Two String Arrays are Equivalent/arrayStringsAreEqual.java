class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String item : word1) {
            sb1.append(item);
        }

        for (String item : word2) {
            sb2.append(item);
        }

        return sb1.toString().equals(sb2.toString());
    }
}
