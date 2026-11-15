-- Write your PostgreSQL query statement below
SELECT name
FROM Customer AS c
WHERE referee_id IS NULL OR referee_id != 2
;