select a.id as Id from weather a join weather b
on datediff (a.recorddate, b.recorddate) = 1
and a.temperature > b.temperature;