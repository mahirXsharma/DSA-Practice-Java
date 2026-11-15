-- Write your PostgreSQL query statement below
SELECT tw.id 
FROM Weather tw
INNER JOIN Weather yw
ON tw.recordDate - yw.recordDate = 1
WHERE tw.temperature > yw.temperature 
;
