# 抄作业了orz
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    declare m INT;
    set m = N-1;
    RETURN (
        # Write your MySQL query statement below.
        select ifnull((select distinct salary from employee order by salary desc limit m,1),null)
        # distinct可以换成 group by 语句，作用一样
    );
END