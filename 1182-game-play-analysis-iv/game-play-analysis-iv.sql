# Write your MySQL query statement below

SELECT ROUND(COUNT(a.player_id)/COUNT(b.player_id),2) AS fraction
FROM Activity a 
RIGHT JOIN 
(SELECT player_id, 
    MIN(event_date) AS first_login
FROM Activity 
GROUP BY player_id) b
ON a.player_id= b.player_id AND DATEDIFF(a.event_date,b.first_login)=1;