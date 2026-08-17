# Write your MySQL query statement below
-- SELECT ROUND(SUM(tiv_2016),2) AS tiv_2016 FROM
-- Insurance
-- WHERE tiv_2015 IN
-- (
--     SELECT tiv_2015 FROM Insurance GROUP BY tiv_2015 HAVING COUNT(tiv_2015)>1
-- )
-- AND
-- (lat,lon) IN 
-- (
--     SELECT lat,lon FROM Insurance GROUP BY lat,lon HAVING COUNT(*)=1
-- )
-- ;


# PARTITION SYNTAX
SELECT ROUND(SUM(tiv_2016),2) as tiv_2016 FROM
(
    Select *,
    COUNT(*) OVER(PARTITION BY tiv_2015) AS tiv_2015_count,
    COUNT(*) OVER(PARTITION BY lat,lon) AS lat_lon_count
    FROM Insurance   
) a
WHERE tiv_2015_count>1 AND lat_lon_count=1;