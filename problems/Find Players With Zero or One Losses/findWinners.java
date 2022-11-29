class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        HashMap<Integer, Integer> lossesCount = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0], loser = match[1];

            lossesCount.put(winner, lossesCount.getOrDefault(winner, 0));
            lossesCount.put(loser, 1 + lossesCount.getOrDefault(loser, 0));
        }

        for (Integer player : lossesCount.keySet()) {
            if (0 == lossesCount.get(player)) {
                result.get(0).add(player);
            } else if (1 == lossesCount.get(player)) {
                result.get(1).add(player);
            }
        }

        Collections.sort(result.get(0));
        Collections.sort(result.get(1));

        return result;
    }
}
