select x,y,z,
if((x + y > z and x + z > y and y + z > x),'Yes','No')
as triangle
from triangle

select x,y,z,
case
when(x + y > z and x + z > y and y + z > x)
then 'Yes'
else 'No'
end as triangle
from triangle