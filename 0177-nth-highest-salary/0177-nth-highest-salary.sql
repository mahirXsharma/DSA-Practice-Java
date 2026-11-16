CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  RETURN QUERY (
    -- Write your PostgreSQL query statement below.
    SELECT MAX(ranked.salary)
    FROM (
        SELECT DENSE_RANK() OVER (ORDER BY e.salary DESC) AS rnk, e.salary
        FROM Employee e
    ) AS ranked
    WHERE ranked.rnk = N
      
  );
END;
$$ LANGUAGE plpgsql;