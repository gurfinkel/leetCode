class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] dArray = dominoes.toCharArray();
        char start = '.';
        char last = '.';
        int strIdx = 0;
        int idx = 0;

        while (n > idx){
            strIdx = idx;

            while (n > idx && '.' == dArray[idx]) {
                ++idx;
            }

            if (n > idx) {
                last = dArray[idx];
            }

            if(0 < idx - strIdx) {
                if ('R' == start && 'L' == last) {
                    int l = strIdx;
                    int r = idx - 1;

                    while(l < r){
                        dArray[l++]='R';
                        dArray[r--]='L';
                    }

                } else if (last=='L') {
                    int l = idx - 1;

                    while (strIdx <= l) {
                        dArray[l--]='L';
                    }
                } else if (start == 'R') {
                    int r = strIdx;

                    while(idx > r) {
                        dArray[r++] = 'R';
                    }
                }
            }

            start = last;
            ++idx;
            last = '.';
        }

        return new String(dArray);
    }
}
