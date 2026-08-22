-- Write your PostgreSQL query statement below
SELECT product_name, year, price FROM product
JOIN sales
ON sales.product_id = product.product_id;