# Write your MySQL query statement below
SELECT CASE WHEN COUNT(*)=0 THEN null ELSE salary END as SecondHighestSalary 
FROM
(
SELECT salary, DENSE_RANK() OVER(ORDER BY salary DESC) AS row_num from Employee
) a
WHERE row_num=2
LIMIT 1;