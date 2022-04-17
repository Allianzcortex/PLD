
以下是 Python 的一些常用技巧：

`如何定义一个二维数组`

```python

dp = [ [0]*(l2+1) for _ in range(l1+1)]

```

`如何定义一个最小堆/最大堆以及相应的 API`

```Python

from heapq import heappush,heappop

queue = []

heappush(queue,3)
heappush(queue,2)
heappush(queue,4)

print(queue[0])
print(heappop(queue))
print(queue[0])
print(heappop(queue))
print(queue[0])
print(heappop(queue))

```

2. 对 Python Counter , 其中 elements() 的函数返回所有出现频率不小于 1 的 key 的结合

比如对：`Counter({'l': 2, 'e': 1, 'b': 0, 'a': 0})` ，生成结果为：`["e","l","l"]`

3.

4.