# Write your MySQL query statement below
#LIMIT and OVER () syntax
SELECT a.person_name 
FROM (Select person_name,SUM(weight) OVER (ORDER BY turn) as weighted_sum, turn from queue) a
WHERE a.weighted_sum<=1000
ORDER BY a.turn DESC
LIMIT 1;