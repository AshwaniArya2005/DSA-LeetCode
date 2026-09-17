# Write your MySQL query statement below
select Department, Employee, Salary from
(select d.name as Department,
 e.name as Employee,
 e.salary as Salary,
 Dense_Rank() Over(partition by e.departmentid order by salary desc) as popularity
 from employee e join department d on e.departmentid = d.id) x
where  popularity <=3;
