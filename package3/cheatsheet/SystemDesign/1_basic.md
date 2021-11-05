

1. 练习网址：

Whimsical.com

2. 设计时需要考虑到的算法：

- Scenario

- Service

- Storage

- Scale

对 Scenario，要做的是：`Outline use cases,constraints,and assumptions`

要问的基本问题包括 Who/How/what

a. 谁来使用？who is going to use it


2. sharding / partitioning 详细解释：



同时来回答：how to scale the system

---

Push 和 Pull

对信息流,push 和 pull 是一种思路：

对其他，是另一种思路：

比如要求一个 youtube video 的点击数量

![push_pull](../../pic/push-pull.png)

push ：直接把 click information 发送给 processing service，然后
processing service 把处理后的数据发送给 database

pull : 把 click information 发送个一个 tempstorage service，然后
processing service 定期从 tempstorage service 里 pull 数据，再把
处理后的数据发送给 database

第二种方法 pull 很显然更好。第一种方法在 processing service crash 的
情况下会丢失数据

---

关于 system design 的 load balancing 



service registry（zookeeper)

consitent hashing explanations

倒排索引(inverted index)
