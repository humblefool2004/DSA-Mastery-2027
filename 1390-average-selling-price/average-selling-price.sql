# Write your MySQL query statement below
SELECT p.product_id,ROUND(
    CASE 
        WHEN SUM(CASE WHEN units IS NULL THEN 0 ELSE units END)=0 THEN 0
    ELSE
        SUM(CASE WHEN price IS NULL OR units IS NULL THEN 0 ELSE price*units END)/
        SUM(CASE WHEN units IS NULL THEN 0 ELSE units END)
    END
    ,2
) as average_price
FROM Prices p 
LEFT JOIN UnitsSold s 
ON p.product_id=s.product_id 
WHERE (purchase_date>=start_date AND purchase_date<=end_date) OR purchase_date IS NULL
GROUP BY p.product_id;


-- p.product_id, 
-- ROUND(
--     SUM(CASE WHEN price IS NULL OR units IS NULL THEN 0 ELSE price*units END)/
--     SUM(CASE WHEN units IS NULL THEN 0 ELSE units END)
--     ,2
-- ) as average_price