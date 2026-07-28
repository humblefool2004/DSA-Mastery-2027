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
        if((employee.subordinates).size() == 0){
            return employee.importance;
        }
        int sum=0;
        for(int num : employee.subordinates){
            sum += recurseEmployee(map.get(num),map);
        }
        return sum+employee.importance;
    }
}