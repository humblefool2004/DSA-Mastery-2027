# Write your MySQL query statement below

SELECT a.product_name, b.unit FROM Products a INNER JOIN 
(SELECT product_id, SUM(unit) AS unit FROM Orders
WHERE DATE_FORMAT(order_date,'%Y-%m')='2020-02'
GROUP BY product_id
HAVING unit>=100) b
ON a.product_id=b.product_id;