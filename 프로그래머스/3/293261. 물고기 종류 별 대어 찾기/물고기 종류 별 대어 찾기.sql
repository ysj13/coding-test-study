with fish_rank as (
    select 
        a.id,
        b.fish_name,
        a.length,
        row_number() over(
            partition by a.fish_type
            order by a.length desc
        ) as ranking
    from fish_info a
    join fish_name_info b on a.fish_type = b.fish_type
)
select 
    id,
    fish_name,
    length
from fish_rank
where ranking = 1
order by id;