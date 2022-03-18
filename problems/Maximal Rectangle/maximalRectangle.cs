public class Solution {
    public int MaximalRectangle(char[,] matrix) {
        int rows = matrix.GetLength(0);
        int cols = matrix.GetLength(1);
        var height = new int[rows][];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            height[i] = new int[cols + 1];
            for (int j = 0; j < cols; j++) {
                if (matrix[i,j] == '0') {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            int area = maxAreaInHist(height[i]);
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }

    int maxAreaInHist(int[] height) {
        var stack = new Stack<int>();

        int i = 0;
        int max = 0;

        while (i < height.Length) {
            if (0 == stack.Count || height[stack.Peek()] <= height[i]) {
                stack.Push(i++);
            } else {
                int t = stack.Pop();
                max = Math.Max(max, height[t] * (0 == stack.Count ? i : i - stack.Peek() - 1));
            }
        }

        return max;
    }
}
