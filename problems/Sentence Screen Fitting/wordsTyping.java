class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int n = s.length();
        int count = 0;
        int[] dp = new int[n];

        for (int idx = 1; n > idx; ++idx) {
            dp[idx] = ' ' == s.charAt(idx) ? 1 : dp[idx - 1] - 1;
        }

        for (int idx = 0; rows > idx; ++idx) {
            count += cols;
            count += dp[count % n];
        }

        return count / n;
    }
}

/*

sentence: ["hello","world"]
rows: 2
cols: 8
s: "hello world "
n: 12
count: 12
dp: [0,-1,-2,-3,-4,1,0,-1,-2,-3,-4,1]

sentence: ["a","bcd","e"]
rows: 3
cols: 6
s: "a bcd e "
n: 8
count: 16
dp: [0,1,0,-1,-2,1,0,1]

sentence: ["i","had","apple","pie"]
rows: 4
cols: 5
s: "i had apple pie "
n: 8
count: 22
dp: [0,1,0,-1,-2,1,0,-1,-2,-3,-4,1,0,-1,-2,1]

*/
