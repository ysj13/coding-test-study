select count(1) as fish_count, fish_name 
from fish_info a join fish_name_info b
on a.fish_type = b.fish_type
group by fish_name
order by count(1) desc