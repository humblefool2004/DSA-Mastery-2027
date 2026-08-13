# Write your MySQL query statement below
#Group by ke saath having clause use krna, having processes after groups are made
SELECT name 
FROM
(SELECT managerId FROM Employee 
    GROUP BY managerId 
    HAVING COUNT(managerId)>=5) a
INNER JOIN 
Employee e ON a.managerId = e.id;