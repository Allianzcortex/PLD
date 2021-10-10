
Problem description:

```
Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| Id          | int     |
| Email       | varchar |
+-------------+---------+
Id is the primary key column for this table.
Each row of this table contains an email. The emails will not contain uppercase letters.
 

Write an SQL query to delete all the duplicate emails, keeping only one unique email with the smallest Id.

Return the result table in any order.

The query result format is in the following example.

 

Example 1:

Input: 
Person table:
+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
Output: 
+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
+----+------------------+
Explanation: john@example.com is repeated two times. We keep the row with the smallest Id = 1.

```

Basic idea:

这道题要用的是 delete 这个命令

如果直接用如下 delete 语句的话会显示冲突

```SQL
delete from Person where Id not in
(select min(id) from Person group by Email)

```

需要用一个中间表来进行优化，对应实现如下

```SQL

delete from Person where Id not in (
select t.id from (
select min(id) as id from Person group by Email
)as t
)

```