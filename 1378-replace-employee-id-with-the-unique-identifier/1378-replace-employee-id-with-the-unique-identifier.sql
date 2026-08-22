-- Write your PostgreSQL query statement below
SELECT name, unique_id FROM employees
LEFT JOIN employeeUNI
ON employees.id = employeeUNI.id

