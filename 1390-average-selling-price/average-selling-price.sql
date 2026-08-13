# Write your MySQL query statement below
#Learned COALESCE If the calculated average is NULL, return 0 instead. here we can write any number instead of 0 too
#SUM FUNCTION IGNORES NULL VALUES.
SELECT p.product_id,
    COALESCE(
        ROUND(
        SUM(price*units)/
        SUM(units)
        ,2)
    ,0
    ) as average_price
FROM Prices p 
LEFT JOIN UnitsSold s 
ON p.product_id=s.product_id 
AND purchase_date BETWEEN start_date AND end_date
GROUP BY p.product_id;
