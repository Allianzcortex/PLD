
这个链接是 grokking system design 里提供的解法：

https://astikanand.github.io/techblogs/high-level-system-design/design-bookmyshow

但我觉得...这里的 reservation 真是太复杂了，感觉并不需要设计如此


与秒杀系统很像

transaction isolation levels

分布式锁的实现：

2 阶段提交 2-phase commit ?

redo log ? undo log ?

MB / GB 读音

ELK 与 MySQL 的同步问题，解决方法：

1. 用 Logstash 官方提供的方法同步

2. 自定义 Binlog 读取，更新到 ES 中

确保 latency 可以接受

这个是 eventual consistency，所以确实可能会有问题，
但考虑到吞吐量 throughput, it should be OK.




Firstly of all :

首先定义好问题，是 cinema 会上传

For our platform:

1. do we have all the tickets info in our database  

or 

2. the cinema will provide API for us to use ?


3. 关于 cache 策略：

cache 应该读取，我们采用的 cache 策略：

client side strategy:

when we update the data in our database, we will mark
the related data of cache [invalid].


4. 关于有多个用户抢票怎么办：

我们有 2 种选择：一是在 application level 加 lock，另外是在 database level 加 lock
如果我们只有 1 个机器的话，可以选择 application level 加
但因为我们选择了 load balancer，会有多个机器，这时候最好确保服务是 stateless 的，尽量在 
db level 加。为了为防止多个用户同时写入一个数据的情况，我们可以设置 isolation level 为
RR(实际上 MySQL 如果采用 InnoDB，默认隔离 level 就是 Repeatable Read)，这样可以阻止：
dirty read / dirty write / non-repeatable read，无法阻止 phantom read，但考虑到两点：

1. 我们只会更新每个 seat 是否是 available/reserved，不会 insert a seat on the fly，所以
不用担心 phantom read 这个问题

2. 我们是构建一个 internet service，想要解决 phantom read 的话只能用设置隔离级别为 serializable
的方法，而这会导致我们处理 concurrency 的能力急剧下降



