class Solution {
    public boolean validWordSquare(List<String> words) {
        var rows = words.size();

        for (int i = 0; rows > i; ++i) {
            for (int j = 0; words.get(i).length() > j; ++j) {
                if (j >= rows || i >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
