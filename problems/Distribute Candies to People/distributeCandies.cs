public class Solution {
    public int[] DistributeCandies(int candies, int num_people) {
        var result = new int[num_people];
        var idx = 0;
        var curr = 1;

        while (0 < candies) {
            if (candies >= curr) {
                result[idx] += curr;
            } else {
                result[idx] += candies;
            }

            candies -= curr++;
            idx = (1 + idx) % num_people;
        }

        return result;
    }
}
