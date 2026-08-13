# Write your MySQL query statement below
#NEW WAY TO USE WHERE CLAUSE, i.e with IN and NOT IN
SELECT 
    ROUND( 
        SUM(order_date= customer_pref_delivery_date)*100/COUNT(customer_id),2 
        ) AS immediate_percentage
FROM Delivery
WHERE (customer_id,order_date) IN
(SELECT customer_id, MIN(order_date)
FROM Delivery 
GROUP BY customer_id);