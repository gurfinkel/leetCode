class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double a = (double)(coordinates[1][1]-coordinates[0][1])/(coordinates[1][0]-coordinates[0][0]);

        for (int i = 2; coordinates.length > i; ++i) {
            double x = coordinates[i][0];
            double y = coordinates[i][1];

            if (a != (y - coordinates[1][1]) / (x - coordinates[1][0])) {
                return false;
            }
        }

        return true;
    }
}
