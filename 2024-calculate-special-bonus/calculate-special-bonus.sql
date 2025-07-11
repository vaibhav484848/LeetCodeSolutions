# Write your MySQL query statement below

Select employee_id,
case
when employee_id%2!=0 AND name  not like 'M%' then salary
ELSE 0
END as bonus
from Employees
order by employee_id;