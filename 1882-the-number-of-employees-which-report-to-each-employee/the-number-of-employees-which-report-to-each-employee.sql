# Write your MySQL query statement below
SELECT a.employee_id,a.name, b.reports_count,b.average_age
FROM Employees a
INNER JOIN
(SELECT reports_to,
    COUNT(*) as reports_count,
    ROUND(AVG(age),0) AS average_age
FROM Employees
WHERE reports_to IS NOT NULL
GROUP BY reports_to) b
ON b.reports_to=a.employee_id
ORDER BY a.employee_id;