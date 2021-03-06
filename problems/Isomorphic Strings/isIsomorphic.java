class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sDict = new HashMap<>();
        HashMap<Character, Character> tDict = new HashMap<>();

        for (int idx = 0; s.length() > idx; ++idx) {
            char sChar = s.charAt(idx);
            char tChar = t.charAt(idx);

            if (sDict.containsKey(sChar)) {
                if (tChar != sDict.get(sChar)) {
                    return false;
                }
            } else {
                sDict.put(sChar, tChar);
            }

            if (tDict.containsKey(tChar)) {
                if (sChar != tDict.get(tChar)) {
                    return false;
                }
            } else {
                tDict.put(tChar, sChar);
            }
        }

        return true;
    }
}
