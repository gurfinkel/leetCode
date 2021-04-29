class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wLen = word.length();
        int aLen = abbr.length();
        int wIdx = 0;
        int aIdx = 0;

        while (wLen > wIdx && aLen > aIdx) {
            if (word.charAt(wIdx) == abbr.charAt(aIdx)) {
                ++wIdx;
                ++aIdx;
            } else if ('0' < abbr.charAt(aIdx) && '9' >= abbr.charAt(aIdx)) {
                int num = abbr.charAt(aIdx++) - '0';

                while (aLen > aIdx && Character.isDigit(abbr.charAt(aIdx))) {
                    num = 10 * num + abbr.charAt(aIdx++) - '0';
                }

                wIdx += num;
            } else {
                return false;
            }
        }

        return (wLen == wIdx) && (aLen == aIdx);
    }
}
