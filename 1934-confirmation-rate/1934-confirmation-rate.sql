-- Write your PostgreSQL query statement below

SELECT s.user_id, COALESCE(p.confirmation_rate, 0.00) AS confirmation_rate
FROM Signups s
LEFT JOIN (
    SELECT c.user_id, ROUND( AVG(CASE WHEN c.action = 'confirmed' 
    THEN 1.00 ELSE 0.00 END) , 2) AS confirmation_rate
    FROM Confirmations c
    GROUP BY c.user_id
) AS p
ON s.user_id = p.user_id
;

