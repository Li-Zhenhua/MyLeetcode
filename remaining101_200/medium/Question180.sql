# Write your MySQL query statement below
--还是窗口函数的应用，日常抄作业
SELECT DISTINCT Num ConsecutiveNums
FROM(
SELECT *,
      --这里的rownum是相同数字连续标号，每个不同数字重新标号
      ROW_NUMBER() OVER (PARTITION BY Num ORDER BY Id) rownum,
      -- id2是为了防止原先的id不连续新建的一个连续id
      ROW_NUMBER() OVER (ORDER BY Id) id2
FROM LOGS
) t
GROUP BY (id2-rownum),Num 
HAVING COUNT(*)>=3