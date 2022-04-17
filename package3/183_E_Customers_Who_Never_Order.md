
Problem description:

```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| Id          | int     |
| Name        | varchar |
+-------------+---------+
Id is the primary key column for this table.
Each row of this table indicates the ID and name of a customer.
 

Table: Orders

+-------------+------+
| Column Name | Type |
+-------------+------+
| Id          | int  |
| CustomerId  | int  |
+-------------+------+
Id is the primary key column for this table.
CustomerId is a foreign key of the ID from the Customers table.
Each row of this table indicates the ID of an order and the ID of the customer who ordered it.
 

Write an SQL query to report all customers who never order anything.

Return the result table in any order.

The query result format is in the following example.

 

Example 1:

Input: 
Customers table:
+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Orders table:
+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Output: 
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+

```

---

Basic idea:

第一种思路是直接用 `in` 来判断:

```SQL

select Name as Customers from Customers
where Id not in (
select distinct(CustomerId) from Orders
)

```

第二种思路是用 `left join` 然后过滤出为 `null` 的数据，这个是最快的:

```SQL

select Name as Customers  from Customers
left join Orders
on Customers.Id = Orders.CustomerId
where Orders.CustomerId is null


```