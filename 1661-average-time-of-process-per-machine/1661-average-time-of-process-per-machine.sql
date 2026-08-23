-- Write your PostgreSQL query statement below
SELECT starts.machine_id,
ROUND(AVG(ends.timestamp-starts.timestamp) :: numeric, 3) 
AS processing_time
FROM Activity AS starts
JOIN Activity AS ends
ON starts.machine_id = ends.machine_id 
AND starts.process_id = ends.process_id 
AND starts.activity_type = 'start' 
AND ends.activity_type = 'end'
GROUP BY starts.machine_id
-- ON starts.machine_id.process_id.activity_type LIKE "start" = ends.machine_id.process_id.activity_type LIKE "end"
