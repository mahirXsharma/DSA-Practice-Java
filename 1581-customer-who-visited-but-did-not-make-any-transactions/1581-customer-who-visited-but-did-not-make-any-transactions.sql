SELECT customer_id, COUNT(customer_id) AS count_no_trans FROM visits
LEFT JOIN transactions
ON visits.visit_id = transactions.visit_id
WHERE transaction_id IS NULL
GROUP BY customer_id