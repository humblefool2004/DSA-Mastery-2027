# Write your MySQL query statement below
SELECT current.id,
CASE 
    WHEN current.id%2=0 
    THEN next.student 
    ELSE COALESCE(prev.student,current.student) 
    END AS student FROM Seat current
LEFT JOIN Seat prev ON prev.id=current.id+1 LEFT JOIN Seat next
ON current.id=next.id+1;