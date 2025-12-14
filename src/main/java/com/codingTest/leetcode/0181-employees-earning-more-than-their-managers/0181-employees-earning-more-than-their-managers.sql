# Write your MySQL query statement below
select 
    e.name as Employee
from
    Employee e
Left Join
    Employee m
On e.managerId = m.id
where e.managerId is not null
and e.salary > m.salary;