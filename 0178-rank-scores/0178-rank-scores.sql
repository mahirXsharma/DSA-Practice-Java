-- Write your PostgreSQL query statement below
SELECT score, DENSE_RANK() OVER (ORDER BY score DESC) AS rank 
FROM Scores s
ORDER BY s.score DESC
;
