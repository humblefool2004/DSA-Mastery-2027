# Write your MySQL query statement below
#LENGTH gives the number of characters in var char
SELECT tweet_id FROM Tweets where LENGTH(content)>15;