# Write your MySQL query statement below

select name from
(select managerId,count(managerId) as cnt from Employee group by managerId having cnt>=5) a
INNER JOIN Employee e ON a.managerId=e.id;