class Solution {
    public int findTheLongestSubstring(String s) {
        int result = 0;
        int prefixXor = 0;
        int[] mp = new int[32];
        int[] characterMap = new int[26];

        characterMap['a' - 'a'] = 1;
        characterMap['e' - 'a'] = 2;
        characterMap['i' - 'a'] = 4;
        characterMap['o' - 'a'] = 8;
        characterMap['u' - 'a'] = 16;
        
        for (int i = 0; i < 32; i++) {
            mp[i] = -1;
        }
        
        for (int idx = 0; s.length() > idx; ++idx) {
            prefixXor ^= characterMap[s.charAt(idx) - 'a'];

            if (mp[prefixXor] == -1 && prefixXor != 0) {
                mp[prefixXor] = idx;
            }

            result = Math.max(result, idx - mp[prefixXor]);
        }

        return result;
    }
}
