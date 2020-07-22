public class Solution {
    public int NumWaterBottles(int numBottles, int numExchange) {
        var result = 0;
        var memory = 0;

        while (0 < numBottles) {
            var numEmptyBottles = numBottles + memory;

            result += numBottles;
            numBottles = numEmptyBottles / numExchange;
            memory = numEmptyBottles % numExchange;
        }

        return result;
    }
}
