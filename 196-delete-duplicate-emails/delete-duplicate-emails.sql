# Write your MySQL query statement below
# sql cant delete from same subquery while processing it.
#hence another subquery is required
DELETE FROM Person WHERE id NOT IN 
(
    SELECT id from
    (SELECT MIN(id) AS id FROM Person GROUP BY email) a
);

