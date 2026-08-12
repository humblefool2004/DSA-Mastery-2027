# Write your MySQL query statement below
#right join, left join, outer join, all requires "ON" keywords.
#Join(mysql specific), Natural join, cross join does not require "ON"
Select unique_id,name from EmployeeUNI RIGHT JOIN Employees ON EmployeeUNI.id= Employees.id;