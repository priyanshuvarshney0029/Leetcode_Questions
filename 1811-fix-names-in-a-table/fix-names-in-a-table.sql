# Write your MySQL query statement below
-- select user_id ,concat( Upper(LEFT(name,1)),LOWER(SUBSTRING(name,2)) as name order by user_id
SELECT 
    user_id,
    CONCAT(UPPER(LEFT(name, 1)), LOWER(SUBSTRING(name, 2))) AS name
FROM 
    users
ORDER BY 
    user_id;
