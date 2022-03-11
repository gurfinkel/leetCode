/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    public void cleanRoom(Robot robot) {
        HashSet<String> visited = new HashSet();

        backtrack(robot, 0, 0, 0, visited);
    }

    public void backtrack(Robot robot, int row, int col, int d, HashSet<String> visited) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        visited.add(row+";"+col);
        robot.clean();

        for (int idx = 0; 4 > idx; ++idx) {
            int newD = (d + idx) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];

            if (!visited.contains(newRow+";"+newCol) && robot.move()) {
                backtrack(robot, newRow, newCol, newD, visited);
                goBack(robot);
            }

            robot.turnRight();
        }
    }

    void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
