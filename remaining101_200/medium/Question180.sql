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


--下面这种方法是假设id连续
SELECT DISTINCT
    l1.Num AS ConsecutiveNums
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num