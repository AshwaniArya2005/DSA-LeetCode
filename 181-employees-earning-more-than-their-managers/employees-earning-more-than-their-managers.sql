# Write your MySQL query statement below
Select e.name as Employee from employee e where e.salary > (select e2.salary from employee e2 where e2.id = e.managerId);