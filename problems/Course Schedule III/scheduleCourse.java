class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> store = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;

        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        for (int[] c: courses) {
            if (time + c[0] <= c[1]) {
                store.add(c[0]);
                time += c[0];
            } else if (!store.isEmpty() && store.peek() > c[0]) {
                time += c[0] - store.poll();
                store.add(c[0]);
            }
        }

        return store.size();
    }
}
