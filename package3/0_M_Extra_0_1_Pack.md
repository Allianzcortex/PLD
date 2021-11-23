
Problem description:

```
0-1 背包问题：

给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，
最多能装的价值是多少？

```

Basic idea:

首先看为什么不能用 ratio 来计算：

因为可以找到反例，比如

weights: [20,30,50]
values:  [20,30,80]



---

实战：

首先是用 recursive 的方法来解决：

对每一个 item，我们可以选择拿，也可以选择不拿，所以代码如下：

```Python

wt = [2,1,3] 
val = [4,2,3]

W = 4
N = len(wt)

def solve(index,max_weight):
    if(index>N-1):
        return 0
    
    res = solve(index+1,max_weight)
    if wt[index]<=max_weight:
        res = max(res,val[index] + solve(index+1,max_weight-wt[index]))
    
    return res

print(solve(0,4))

```

但是显然上面的方法有很多重合的地方，所以我们可以用一个 cache 来优化：
用 `index_maxweight` 来生成一个 unique id :

```Python
cache = {}

def solve(index,max_weight):
    if(index>N-1):
        return 0
    unique_id = f"{index}_{max_weight}"
    if unique_id in cache:
        return cache[unique_id]
    res = solve(index+1,max_weight)
    if wt[index]<=max_weight:
        res = max(res,val[index] + solve(index+1,max_weight-wt[index]))
    
    cache[unique_id] = res
    return res

print(solve(0,W))

```

在此之后再进一步就是自底向上的 DP 解法：

This is Python solution:

```Python

wt = [2,1,3] 
val = [4,2,3]

W = 4
N = len(wt)

dp = [[0]*(W+1) for _ in range(N+1)]

# 2 metrics: 1. how many items we can have 
# 2. current weight we can have

# dp[N][W] // N : N items , W current weight
# dp[i][j] means : pick up items from [1..i] , maximum weight limit is
# j , dp[i][j] is the maximum value we can get

# case 1 : we don't choose it dp[i][j] = dp[i-1][j]
# case 2 : we choose it       dp[i][j] = dp[i-1][j-weight[i]] + vale[i]
# get the max value from two of them

for i in range(1,N+1):
    for j in range(1,W+1):
        dp[i][j] = dp[i-1][j]
        # if we can pick the current item
        if (wt[i-1]<=j):
            dp[i][j] = max(dp[i][j],dp[i-1][j-wt[i-1]]+val[i-1])

print(dp[-1][-1])

```


