-- Write your PostgreSQL query statement below
SELECT name, unique_id
FROM Employees AS e
LEFT JOIN EmployeeUNI AS u
ON e.id = u.id
;
