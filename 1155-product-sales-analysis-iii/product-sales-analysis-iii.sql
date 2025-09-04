# Write your MySQL query statement belowF
Select product_id,year as first_year,quantity,price
from Sales 
Where (product_id,year) IN (select product_id, MIN(year) from Sales
Group by product_id)
