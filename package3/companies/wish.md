High Frequency Problem


[√] LC 172  - [1]
[√] LC 33  - [1]
[] LC 53 Maximum Subarray - [1]
[] LC 152 Maximum Product Subarray - [1]
[] LC 200 Number of Islands - [1]
[] LC 227 Basic Calculator II - [1]
[] LC 224 Basic Calculator - [1]

[] LC 311 Sparse Matrix Multiplication - [2]

[] LC 207 Course Schedule - [3]
[] LC 210 Course Schedule II - [3]
[] LC 630 Course Schedule III - [3]

[] LC 399 Evaluate Division - [4]
- Request is too high,how to optimize it ?(add cache) - [4]

[] Design - [5]

```
设计一个class，有三个方法，add remove getRandom，可以add 和 remove给定的product id，然后getRandom返回一个随机的product id。用了hashmap加array解决
```

[] Two Pointers  - [5]

```
给一个sorted int array，然后给一个target number，要求范围target在array里的index区间。没有的话返回-1
比如[0,1,2,3,3]
1 -> [1, 1]
3 -> [3, 4]
-1 ->[-1, -1]
5 -> [-1, -1]
我一开始说用hashmap，扫一遍array然后存对应的index。面试官说我只query很少次数，然后我说那就binary search，后来写的时候有点bug，后来调试出来了。估计应该挂了
```

[] Deque - [6]

```
given large amont log data(format: timestamp, user id), detect all users that visits over X times in any given Y mins time window.
提了几个想法，面试官都不满意。后来意识到他想我用 deque 节省空间。匆忙写代码， 运行有 bug， 时间不够了。剩下就是客套了。一周后通知没过。
```

[] - 简单版蠡口计算器伞。一个括号里只允许有一个operator，没有减法。比如(((1+2) * 3) + 4)。 - [7]

[] - 从浏览器输入url之后发生了什么开始问问题。问了DNS怎么工作。问了tls的通信机制。然后在terminal跑了一个dig几个curl，详细问了每个response里的每一个field是表示什么的，为什么需要这个东西。 - [7]


[] LC 207 Course Schedule - [8]
[] LC 210 - Course Schedule II  [8]
Tow 2 problems are duplicated with previously mentioned

[] - [9] Design Problem

[] - LC 112  Path SUm [10]
[] - LC 96 Unique Binary Search Trees [10]

[] - LC 399 [10]  - There is a follow up :

```
第二轮用了标准的DFS解，但是感觉followup第一问答得不好：如何优化空间复杂度？我给了个加上union find的思路，只把空间缩小到了一半，所以这可能就是挂点了。第二问如何优化时间复杂度，我说每次计算出来正数的结果就保存从而简化将来的计算，面试官说好。
```

[] - LC 1067  [11]

[] - LC 528 [12]

[] - LC VO [13]

 design： upload photo的系统
- coding: vertical order traversal binary tree, no need to sort per column
- coding: random pick with weight, 有insert和pick两个method，followup是insert dup key的时候的两种处理方式（weight累加还是替代，后者比较麻烦，需要用segment tree）

[] - LC 一轮电面 [14]

给定最大capacity，判断增加一个event(starttime, endtime) 会不会超过capacity, 思路类似 LC 252

[] - LC 一轮电面 [15]

Infra 组：
```
coding 就一个题目，list of integer，根据连续出现的数字的个数来压缩，比如  3 3 3 4 4 6 -》 3 3 2 4 1 6， 压缩完先是count 然后是具体的数字，followup就是怎么解压缩反向输出，只不过反向输出的时候要写成一个iterator的形势，也比较容易。多问corner case，多提供几个test case
```

[] - LC  [16]

电面 LC 125  LC 680 LC 200

[] - LC 210 电面 Course Schedule 真是高频题[17]

[] - LC 2道bq, challenge, strength  [18]
coding 是 min sum from top left of a matrix to bottom right.

[] - 电面 LC 399 (DFS) LC 37 

[] - 电面

```
design referral mobile system
design lottery system

merge two sorted lists, k lists
LC 200 islands


```

[] - [20]

```
题目是设计一个存储
提供 (1)加一笔数据 (2)移除一笔数据 (3)列出所有数据 这三个功能
面试官对于API完全没有要求，所以大部分时间都在与面试官讨论API与打印数据的顺序

Follow up是增加 (1)找出最旧的数据 (2)找出最新加入的数据 这两个功能
```

[] 电面 [21]

```
找permutation substring，比如：
given t="abdcabcba" w="abc"
return ["cab", "abc", "cba"]
用sliding window做的，忘了是利口哪一题了。

```

[] 电面 [22]

LC 403 Frog Jump

[] 电面 528 绝对高频题

```
LC 528 变形

支持两个API

addWeight(String key, value);
String pickRandom()

如果加同一个KEY 多次， 分别考虑两种情况
1. Accumulated
2. Replace 原有KEY的值

```

---

电面：

LC 731

LC 1129

高频题：K Sorted Array:

```
给一个数组，和一个k，k表示 数组元素 离 排序后正确位置的 最大距离，要求把数组排序
比如
[1,2,3], k = 0 -> [1,2,3]
[2,1,3], k = 1 -> [1,2,3]
[3,1,2], k = 2 -> [1,2,3]

面试官提示了一下，用长度为k的sliding window，每次拿出最小的放在window的最前面，然后一遍过，用heap的话时间复杂度就是O(nlogk)

参考：https://www.geeksforgeeks.org/nearly-sorted-algorithm/

```

LC 题目：209

大于 target 的最小 subarray

---









reference list :

1. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=662975&ctid=230589

2. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=662954&ctid=230384 

3. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=661014&ctid=230384

```
Given a list of currency_pairs = [('USD', 'CNY'), ('JPY', 'USD'), ('CNY', 'JPY'), ('CAD', 'USD'), ('BRL', 'USD')] where each pair is a (from_currency, to_currency) tuple
and a list of exchange_rates = [6.95, 0.0093, 15.34, 0.75, 0.18] where element i is the exchange rate corresponds to currency exchange pair i in the list of currency_pairs.
For instance, currency_pairs[0] together with exchanges_rates[0] means that 1 USD = 6.95 CNY.

Input:
from_currency: BRL, to_currency: CAD

Output:
0.2394

Explanation:

BRL-> USD = 0.18
USD -> CAD = 1 / 0.75 = 1.33
BRL -> CAD = 0.18 * 1.33 = 0.2394
```

This problem looks like a combination of `course schedule` and `DFS/BFS`

4. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=659814&ctid=230384

5. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=658538&ctid=230384

6. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=654238&ctid=230384

7. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=652466&ctid=230384

8. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=651694&ctid=230384

9. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=649263&ctid=230384

```
设计一个marketplace class， 里面有两个function,
第一个 void sellProduct(String product_id, int price, int quantity) ,
同一个product 可以有不同的price 和 quantity ,
E.g product 1 可以有不同的price 对应 quantity
Sell Product_1   $20  100
                          $10  200
                          $30  50

第二个function 是buyer 想要buy product，
public int[] buyProducts(String product_id, int quantity, int max_average_price)   
//return new int[]{total amount quantity buy, total amount money pay}

Buyer buy(product_1, 500, 12) → [200 , 2000]
Sell Product_1 就更新成   $20  100
                                         $10  0
                                         $30  50

当时没跟面试官clarify清楚是不是要buyer 的quantity 最大化还是seller 的profit 最大化，在hackerrank上面经常报错，面试一紧张头脑一片空白没法思考，第二个function 没写完，卒
```

10. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=647469&ctid=230384

11. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=645868&ctid=230384

12. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=644350&ctid=230384


13. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=639832&ctid=230384

14. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=637504&ctid=230384

15. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=634748&ctid=230384

16. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=633751&ctid=230384

17. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=630778&ctid=230384

18. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=629783&ctid=230384

19. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=629011&ctid=230384

20. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=628487&ctid=230384

21. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=626173&ctid=230384

22. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=612581&ctid=230384

23. https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=609357&ctid=230384