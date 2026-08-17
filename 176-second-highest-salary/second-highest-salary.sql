# Write your MySQL query statement below
SELECT MAX(salary) AS SecondHighestSalary 
FROM
(
SELECT salary, DENSE_RANK() OVER(ORDER BY salary DESC) AS row_num from Employee
) a
WHERE row_num=2;