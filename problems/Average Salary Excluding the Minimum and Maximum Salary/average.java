class Solution {
    public double average(int[] salary) {
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        int sum = 0;

        for (int item : salary) {
            // Sum of all the salaries.
            sum += item;
            // Update the minimum salary.
            minSalary = Math.min(minSalary, item);
            // Update the maximum salary.
            maxSalary = Math.max(maxSalary, item);
        }

        // Divide the sum by total size - 2, as we exclude minimum and maximum values.
        return (double)(sum - minSalary - maxSalary) / (double)(salary.length - 2);
    }
}
