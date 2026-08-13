# Write your MySQL query statement below
#NEW WAY TO USE WHERE CLAUSE, i.e with IN and NOT IN
#SUM(IF(condition,trueVal,falseVal)) #new concept
#GROUP BY 1 means, group by 1st column in the select


-- SELECT 
--     ROUND( 
--         SUM(order_date= customer_pref_delivery_date)*100/COUNT(customer_id),2 
--         ) AS immediate_percentage
-- FROM Delivery
-- WHERE (customer_id,order_date) IN
-- (SELECT customer_id, MIN(order_date)
-- FROM Delivery 
-- GROUP BY customer_id);

SELECT 
ROUND(
    SUM(first_order_date=customer_pref_delivery_date)*100/COUNT(a.customer_id)
    ,2
) AS immediate_percentage
FROM Delivery a
INNER JOIN
(SELECT customer_id,
    MIN(order_date) as first_order_date
    FROM Delivery 
    GROUP BY customer_id) b
ON a.customer_id=b.customer_id AND order_date=first_order_date;