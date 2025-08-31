# Write your MySQL query statement below
select customer_id from customer 
Group By customer_id 
Having count(Distinct product_key) = (select count(product_key) from product) 