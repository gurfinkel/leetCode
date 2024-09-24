class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Character, String> digitToLettersMap = new HashMap<>();
        
        digitToLettersMap.put('2', "abc");
        digitToLettersMap.put('3', "def");
        digitToLettersMap.put('4', "ghi");
        digitToLettersMap.put('5', "jkl");
        digitToLettersMap.put('6', "mno");
        digitToLettersMap.put('7', "pqrs");
        digitToLettersMap.put('8', "tuv");
        digitToLettersMap.put('9', "wxyz");
        
        backtrack(digits, digitToLettersMap, 0, result, new StringBuilder());

        return result;
    }

    private void backtrack(String digits, HashMap<Character, String> digitToLettersMap, int idx, List<String> result, StringBuilder path) {
        if (digits.length() == path.length()) {
            if (0 < path.length()) {
                result.add(path.toString());
            }
            
            return;
        }

        String letters = digitToLettersMap.get(digits.charAt(idx));

        for (char letter : letters.toCharArray()) {
            path.append(letter);
            backtrack(digits, digitToLettersMap, 1 + idx, result, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
