# Write your MySQL query statement below

-- SELECT a.product_name, b.unit FROM Products a INNER JOIN 
-- (SELECT product_id, SUM(unit) AS unit FROM Orders
-- WHERE DATE_FORMAT(order_date,'%Y-%m')='2020-02'
-- GROUP BY product_id
-- HAVING unit>=100) b
-- ON a.product_id=b.product_id;

SELECT a.product_name,SUM(b.unit) AS unit 
FROM Products a 
INNER JOIN Orders b
USING(product_id)
WHERE order_date BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY a.product_id
HAVING unit>=100;