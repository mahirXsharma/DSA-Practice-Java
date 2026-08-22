SELECT today.id
FROM weather AS today
JOIN weather AS yesterday
ON today.recordDate - yesterday.recordDate = 1
WHERE today.temperature > yesterday.temperature