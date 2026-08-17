# Write your MySQL query statement below
#rows between syntax inside over thing,and row_number() and 
SELECT visited_on,amount,average_amount
FROM 
(
    SELECT visited_on, SUM(daily_amount) OVER(
    ORDER BY visited_on 
    ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
) AS amount,
ROUND(
    SUM(daily_amount) OVER(
    ORDER BY visited_on 
    ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
    )/7
    ,2
) AS average_amount,
ROW_NUMBER() OVER(ORDER BY visited_on) as rn
FROM
(SELECT visited_on, sum(amount) as daily_amount from Customer GROUP BY visited_on) x
) a
WHERE rn>=7
ORDER BY visited_on;