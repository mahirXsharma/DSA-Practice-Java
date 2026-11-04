-- Write your PostgreSQL query statement below
SELECT m.name
FROM Employee m
INNER JOIN Employee e
ON m.id = e.managerId
GROUP BY m.id,m.name
HAVING COUNT(e.id) >= 5
;


