# Write your MySQL query statement below
-- SELECT product_id,new_price AS price FROM Products WHERE (product_id, change_date) IN
-- (SELECT product_id,MAX(change_date) FROM Products WHERE change_date<='2019-08-16' GROUP BY product_id)
-- UNION
-- SELECT p.product_id, 10 AS price FROM products p 
-- WHERE NOT EXISTS
-- (
--     SELECT x.product_id FROM Products x WHERE 
--     x.product_id=p.product_id 
--     AND x.change_date<='2019-08-16'
-- );


SELECT a.product_id, COALESCE(b.price,10) AS price 
FROM Products a 
LEFT JOIN
(SELECT product_id,new_price AS price FROM Products WHERE (product_id, change_date) IN
(SELECT product_id,MAX(change_date) FROM Products WHERE change_date<='2019-08-16' GROUP BY product_id)
) b
ON a.product_id=b.product_id
GROUP BY a.product_id;
