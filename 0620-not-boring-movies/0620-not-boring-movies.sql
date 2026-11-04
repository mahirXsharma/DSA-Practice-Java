-- Write your PostgreSQL query statement below
SELECT * 
FROM Cinema c
WHERE c.id %2 != 0
AND description NOT LIKE 'boring'
ORDER BY c.rating DESC
;
