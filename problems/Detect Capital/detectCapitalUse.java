class Solution {
    public boolean detectCapitalUse(String word) {
        if (null == word || 0 == word.length()) {
            return true;
        }

        String firstLetter = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
        String lowerCase = word.toLowerCase();
        String upperCase = word.toUpperCase();

        return (word.equals(firstLetter) || word.equals(lowerCase) || word.equals(upperCase));
    }
}
