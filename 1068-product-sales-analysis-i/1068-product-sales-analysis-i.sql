-- Write your PostgreSQL query statement below
SELECT product.product_name, sales.year, sales.price FROM product
JOIN sales
ON sales.product_id = product.product_id;