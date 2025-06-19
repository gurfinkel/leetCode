class Solution {
    public double separateSquares(int[][] squares) {
        if (0 == squares.length) {
            return 0.0;
        }

        TreeMap<Long, Long> heightToHorizontalLineMap = new TreeMap<>();
        long area = getFullAreaAndFillMap(squares, heightToHorizontalLineMap);
        double halfArea = area/2.0;
        long prevLineIdx = heightToHorizontalLineMap.firstKey();
        long sumLinesBefore = 0;
        long sumLines = 0;

        for (Map.Entry<Long,Long> item : heightToHorizontalLineMap.entrySet()) {
            long currentLineIdx = item.getKey();

            if (currentLineIdx > prevLineIdx && 0 < sumLines) {
                long currentSegment = (currentLineIdx - prevLineIdx) * sumLines;

                if (sumLinesBefore + currentSegment >= halfArea) {
                    double need = halfArea - sumLinesBefore;
                    return prevLineIdx + need / (double) sumLines;
                }

                sumLinesBefore += currentSegment;
            }

            sumLines += item.getValue();
            prevLineIdx = currentLineIdx;
        }

        return prevLineIdx;
    }

    private long getFullAreaAndFillMap(int[][] squares, TreeMap<Long, Long> map) {
        long result = 0;

        for (int[] square : squares) {
            long height = square[1];
            long horizontalLine = square[2];

            map.merge(height, horizontalLine, Long::sum);
            map.merge(height + horizontalLine, -horizontalLine, Long::sum);
            result += horizontalLine * horizontalLine;
        }

        return result;
    }
}
