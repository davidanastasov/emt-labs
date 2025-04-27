create materialized view books_per_author as
select a.id        as author_id,
       count(b.id) as num_books
from author a
         left join
     book b on b.author_id = a.id
group by a.id;
