class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> result = new ArrayList<>();
        List<int[]> store = new ArrayList<>();

        for (int[] restaurant : restaurants) {
            if ((1 == veganFriendly && 0 == restaurant[2]) ||
               (maxPrice < restaurant[3]) ||
               (maxDistance < restaurant[4])) {
                continue;
            }

            store.add(restaurant);
        }

        store.sort((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);

        for (int[] restaurant : store) {
            result.add(restaurant[0]);
        }

        return result;
    }
}
