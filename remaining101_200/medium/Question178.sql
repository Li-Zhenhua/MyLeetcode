/*编写一个 SQL 查询来实现分数排名。

如果两个分数相同，则两个分数排名（Rank）相同。
请注意，平分后的下一个名次应该是下一个连续的整数值。
换句话说，名次之间不应该有“间隔”。
*/

# Write your MySQL query statement below
--涉及到排名的问题，都可以使用窗口函数来解决。
--记住rank, dense_rank, row_number排名的区别
/*
1）rank函数：
如果有并列名次的行，会占用下一名次的位置。
比如正常排名是1，2，3，4，但是现在前3名是并列的名次，
结果是：1，1，1，4。

2）dense_rank函数：
如果有并列名次的行，不占用下一名次的位置。
比如正常排名是1，2，3，4，但是现在前3名是并列的名次，
结果是：1，1，1，2。

3）row_number函数：
不考虑并列名次的情况。
比如前3名是并列的名次，排名是正常的1，2，3，4。
*/
select Score, dense_rank() over (order by score desc) as 'Rank' from Scores

#下面是不用窗口函数的写法
select a.Score as Score,
(select count(distinct b.Score) from Scores b where b.Score >= a.Score) as 'Rank'
from Scores a
order by a.Score DESC