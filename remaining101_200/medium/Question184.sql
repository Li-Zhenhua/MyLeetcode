/*
Employee 表包含所有员工信息，
每个员工有其对应的 Id, salary 和 department Id。
Department 表包含公司所有部门的信息。
编写一个 SQL 查询，找出每个部门工资最高的员工。
*/

# Write your MySQL query statement below
--子查询，这个in是真没想到
select d.name as 'Department',e.name as 'Employee',e.Salary from Department d,Employee e
where d.Id = e.DepartmentId and (e.DepartmentId, Salary) 
IN (SELECT DepartmentId, max(Salary) 
    FROM Employee 
    GROUP BY DepartmentId )