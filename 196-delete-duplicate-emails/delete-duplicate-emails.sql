# Write your MySQL query statement below
DELETE FROM Person WHERE id NOT IN 
(
    SELECT id from
    (SELECT MIN(id) AS id FROM Person GROUP BY email) a
);