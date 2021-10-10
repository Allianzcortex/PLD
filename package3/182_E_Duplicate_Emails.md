
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
 

Write an SQL query to report all the duplicate emails.

Return the result table in any order.

The query result format is in the following example.

 

Example 1:

Input: 
Person table:
+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
Output: 
+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Explanation: a@b.com is repeated two times.

```

Basic idea:

标准思路，用 `group by` 以后比较 count

```SQL

select Email from Person
group by Email
having count(Email)>1

```
