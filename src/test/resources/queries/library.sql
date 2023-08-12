# US01 - 1

select count(id) from users; -- actual

select count(distinct id) from users; -- expected

# US01 - 2
select * from users;

# US02
select count(*) from book_borrow
where is_returned = 0;


# US03
select name from book_categories;


# US04
select * from books
where name = 'Afzals Legacy';


# US05
select book_id from book_borrow
group by book_id
order by count(*) desc
limit 1;

select book_category_id from books
where id = (select book_id from book_borrow
            group by book_id
            order by count(*) desc
            limit 1);

select name from book_categories
where id = (select book_category_id from books
            where id = (select book_id from book_borrow group by book_id order by count(*) desc limit 1));



# US06
select * from books
where author = 'J. R. R. Tolkien';

