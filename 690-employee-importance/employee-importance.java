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
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee employee : employees){
            map.put(employee.id,employee);
        }
        return recurseEmployee(map.get(id),map);

    }
    private int recurseEmployee(Employee employee,Map<Integer,Employee>  map){
        int sum=employee.importance;
        for(int subId : employee.subordinates){
            sum += recurseEmployee(map.get(subId),map);
        }
        return sum;
    }
}