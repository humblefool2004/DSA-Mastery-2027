# Write your MySQL query statement below
SELECT s.id,
CASE 
    WHEN s.id%2=0 
    THEN m.student 
    ELSE IFNULL(t.student,s.student) 
    END AS student FROM Seat s
LEFT JOIN Seat t ON t.id=s.id+1 LEFT JOIN Seat m
ON s.id=m.id+1