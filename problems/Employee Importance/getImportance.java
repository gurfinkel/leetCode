/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> store = new HashMap<>();

        for (Employee employee: employees) {
            store.put(employee.id, employee);
        }

        return dfs(id, store);
    }

    public int dfs(int id, HashMap<Integer, Employee> store) {
        Employee employee = store.get(id);
        int result = employee.importance;

        for (int childId : employee.subordinates) {
            result += dfs(childId, store);
        }

        return result;
    }
}
