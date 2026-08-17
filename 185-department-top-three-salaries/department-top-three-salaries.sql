# Write your MySQL query statement below
-- ROW_NUMBER()
-- Every row gets a unique number
-- RANK()
-- Same values get the same rank, but gaps occur:
-- DENSE_RANK()
-- Same values get the same rank, without gaps:

SELECT Department,
Employee,
Salary 
FROM (
    SELECT d.name AS Department,e.name AS Employee,e.salary AS Salary, DENSE_RANK() OVER(PARTITION BY e.departmentId ORDER BY e.salary DESC ) AS dn FROM Employee e
INNER JOIN Department d
ON e.departmentId=d.id
) a
WHERE dn<=3;