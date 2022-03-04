class Solution {
    public int minArea(char[][] image, int x, int y) {
        int left =  smallest(image, 0, y, false);
        int right = largest(image, y, image[0].length, false);
        int top = smallest(image, 0, x, true);
        int down = largest(image, x, image.length, true);

        return (1 + right - left) * (1 + down - top);
    }

    private int smallest(char[][] image, int left, int right, boolean horizontal) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (hasBlack(image, mid, horizontal)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (hasBlack(image, left, horizontal)) {
            return left;
        }

        return right;
    }

    private int largest(char[][] image, int left, int right, boolean horizontal) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (hasBlack(image, mid, horizontal)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private boolean hasBlack(char[][] grid, int index, boolean horizontal) {
        if (horizontal) {
            for (int idx = 0; grid[0].length > idx; ++idx) {
                if ('1' == grid[index][idx]) {
                    return true;
                }
            }
        } else {
            for (int idx = 0; grid.length > idx; ++idx) {
                if ('1' == grid[idx][index]) {
                    return true;
                }
            }
        }

        return false;
    }
}
