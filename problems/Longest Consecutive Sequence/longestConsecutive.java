class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashSet<Integer> store = new HashSet<>();

        for (int num : nums) {
            store.add(num);
        }

        for (int num : store) {
            if (!store.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (store.contains(1 + currentNum)) {
                    ++currentNum;
                    ++currentStreak;
                }

                result = Math.max(result, currentStreak);
            }
        }

        return result;
    }

//     For those who got confused by if the solution is O(n^2) or O(n), please take a close look at the entering of the logic: if(!num_set.contains(num-1)).
//     That means, for example, 6,5,4,3,2,1 input, only the value 1 is valid for the loop(all other values have its value - 1 in the set), that is O(n).
//     Another corner example, 2, 5, 6, 7, 9, 11. All of these numbers are the "entrance" for the logic but the while loop doesn't run much. That is O(n) as well.
}
