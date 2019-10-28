select a.name, b.bonus from employee a left join bonus b
on b.empid = a.empid 
where b.bonus < 1000 or bonus is null;



select e.name,b.bonus
from employee e left join bonus b
on e.empid=b.empid
where
ifnull(bonus,0)<1000 ;