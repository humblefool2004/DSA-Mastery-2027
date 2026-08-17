# Write your MySQL query statement below
-- GROUP_CONCAT(
--     DISTINCT name
--     ORDER BY name
--     SEPARATOR ' | '
-- )
SELECT sell_date,COUNT(DISTINCT product) AS num_sold,GROUP_CONCAT(DISTINCT product ORDER BY product) AS products FROM Activities GROUP BY sell_date ORDER BY sell_date;