# Write your MySQL query statement below
select m.name from employee e join employee m on m.id = e.managerid group by m.id,m.name having count(e.id) >=5