# Write your MySQL query statement below
-- SELECT employee_id,department_id 
-- FROM Employee
-- WHERE primary_flag='Y'
-- UNION
-- SELECT employee_id, department_id 
-- FROM Employee
-- GROUP BY employee_id
-- HAVING COUNT(DISTINCT department_id)=1;

SELECT employee_id,department_id
FROM Employee
WHERE primary_flag='Y'
OR employee_id IN (
    SELECT employee_id FROM employee GROUP BY employee_id HAVING COUNT(*)=1
);