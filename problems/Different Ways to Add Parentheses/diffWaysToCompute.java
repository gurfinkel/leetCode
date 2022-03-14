class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        return diffWaysToCompute(expression, new List[n][n], 0, n-1);
    }

    private List<Integer> diffWaysToCompute(String expression, List[][] memo, int l, int r) {
        if (memo[l][r] != null)
            return memo[l][r];
        List<Integer> result = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> lefts = diffWaysToCompute(expression, memo, l , i-1);
                List<Integer> rights = diffWaysToCompute(expression, memo, i+1 , r);
                for (int left: lefts) {
                    for (int right: rights) {
                        switch(c){
                            case '+':
                                result.add(left+right);
                                break;
                            case '-':
                                result.add(left-right);
                                break;
                            case '*':
                                result.add(left*right);
                                break;
                        }
                    }
                }
            }
        }
        if (result.isEmpty()){
            result.add(Integer.parseInt(expression.substring(l ,r+1)));
        }
        memo[l][r] = result;
        return result;
    }
}
