# Write your MySQL query statement below

SELECT a.requester_id as id, SUM(c) as num FROM
(
select requester_id , COUNT(*) as c FROM RequestAccepted GROUP BY  requester_id

UNION ALL

select accepter_id, COUNT(*) FROM requestAccepted GROUP BY accepter_id
) a

GROUP BY id
ORDER BY num DESC
LIMIT 1;