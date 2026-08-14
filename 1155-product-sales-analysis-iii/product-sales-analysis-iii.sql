# Write your MySQL query statement below

-- SELECT a.product_id,b.first_year, a.quantity,a.price
-- FROM Sales a
-- RIGHT JOIN
-- (SELECT product_id,MIN(year) AS first_year
-- FROM Sales
-- GROUP BY product_id) b
-- ON a.product_id=b.product_id AND a.year= b.first_year;

SELECT product_id, year AS first_year, quantity, price
FROM Sales
WHERE (product_id, year) IN (
    SELECT product_id, MIN(year)
    FROM Sales
    GROUP BY product_id
);