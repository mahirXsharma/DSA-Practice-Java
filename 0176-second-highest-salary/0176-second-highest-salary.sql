-- Write your PostgreSQL query statement below

SELECT MAX(ranked.salary) AS SecondHighestSalary 
FROM (  
        SELECT DENSE_RANK() OVER (ORDER BY e.salary DESC) AS rnk, salary 
        FROM Employee e
    ) AS ranked

WHERE ranked.rnk = 2
;