class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new LinkedList<>();

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        });

        for (int[] item : people) {
            result.add(item[1], item);
        }

        return result.toArray(new int[result.size()][2]);
    }
}
