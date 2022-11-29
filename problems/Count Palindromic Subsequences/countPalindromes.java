class Solution {
    public int countPalindromes(String s) {
        int mod = 1000_000_007;
        int ret = 0;
        char[] c = s.toCharArray();

        for (int i = 0; i < 10; i ++){
            for (int j = 0; j < 10; j ++){
                char[] cc = new char[]{(char)('0'+i),(char)('0'+j),(char)(0),(char)('0'+j),(char)('0'+i)};
                int[] dp = new int[6];
                dp[5] = 1;

                for (int ci = 0 ; ci < c.length; ci ++){
                    for (int cj = 0; cj < 5; cj ++){
                        if (c[ci]==cc[cj]|| cj == 2){
                            dp[cj]+=dp[cj+1];
                            dp[cj]%=mod;
                        }
                    }
                }
                ret = (ret+dp[0])%mod;
            }
        }
        return ret;
    }
}
