package remaining101_200.easy;
/**
 * 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，
 * 都需要基于上述两表提供 person 的以下信息：
 * FirstName, LastName, City, State
 */
//没想到竟然有sql语句的题！！

//外联结
select p.FirstName, p.LastName, a.City, a.State 
from Person p left join Address a on 
p.PersonId = a.PersonId;

public class Question175 {
    
}
