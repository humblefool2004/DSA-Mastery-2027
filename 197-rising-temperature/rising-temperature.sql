# Write your MySQL query statement below
#DATEDIFF is used to find the difference in dates in days.
SELECT w1.id from weather w1 INNER JOIN weather w2 on DATEDIFF(w1.recordDate, w2.recordDate)= 1 where w1.temperature > w2.temperature;