select category, sum(sales) as total_sales
from book_sales a join book b 
on a.book_id = b.book_id
where sales_date between '2022-01-01' and '2022-01-31'
group by category
order by category

