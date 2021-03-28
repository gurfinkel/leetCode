class Solution {
    public String originalDigits(String s) {
        StringBuilder result = new StringBuilder();
        char[] letterFrequencies = new char[26 + 'a'];
        int[] digitFrequencies = new int[10];

        for(char letter: s.toCharArray()) {
            ++letterFrequencies[letter];
        }

        // letter "z" is present only in "zero"
        digitFrequencies[0] = letterFrequencies['z'];
        // letter "w" is present only in "two"
        digitFrequencies[2] = letterFrequencies['w'];
        // letter "u" is present only in "four"
        digitFrequencies[4] = letterFrequencies['u'];
        // letter "x" is present only in "six"
        digitFrequencies[6] = letterFrequencies['x'];
        // letter "g" is present only in "eight"
        digitFrequencies[8] = letterFrequencies['g'];
        // letter "h" is present only in "three" and "eight"
        digitFrequencies[3] = letterFrequencies['h'] - digitFrequencies[8];
        // letter "f" is present only in "five" and "four"
        digitFrequencies[5] = letterFrequencies['f'] - digitFrequencies[4];
        // letter "s" is present only in "seven" and "six"
        digitFrequencies[7] = letterFrequencies['s'] - digitFrequencies[6];
        // letter "i" is present in "nine", "five", "six", and "eight"
        digitFrequencies[9] = letterFrequencies['i'] - digitFrequencies[5] - digitFrequencies[6] - digitFrequencies[8];
        // letter "n" is present in "one", "nine", and "seven"
        digitFrequencies[1] = letterFrequencies['n'] - digitFrequencies[7] - 2 * digitFrequencies[9];

        for(int i = 0; 10 > i; ++i) {
            for (int j = 0; digitFrequencies[i] > j; ++j) {
                result.append(i);
            }
        }

        return result.toString();
  }
}
