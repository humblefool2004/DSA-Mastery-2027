# Write your MySQL query statement below
(
Select Users.name AS results from MovieRating  LEFT JOIN Users ON Users.user_id=MovieRating.user_id
GROUP BY MovieRating.user_id
ORDER BY Count(*) DESC, Users.name
LIMIT 1
)
UNION ALL

(
SELECT b.title FROM MovieRating a LEFT JOIN Movies b 
ON a.movie_id=b.movie_id
WHERE DATE_FORMAT(a.created_at,'%Y-%m')='2020-02'
GROUP BY a.movie_id 
ORDER BY AVG(a.rating) DESC,b.title
LIMIT 1
);