class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> answer = new ArrayList();

        factors(n, 2, new ArrayList(), answer);

        return answer;
    }

    private void factors(int n, int start, List<Integer> temp, List<List<Integer>> output) {
        if (n <= 1) {
            if (temp.size() > 1)
                output.add(new ArrayList(temp));
            return;
        }

        int bound = (int)Math.sqrt(n);
        for (int i = start; i <= bound; i++) {
            if (n % i == 0) {
                temp.add(i);
                temp.add(n / i);
                output.add(new ArrayList(temp));
                temp.remove(temp.size() - 1);
                factors(n / i, i, temp, output);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
