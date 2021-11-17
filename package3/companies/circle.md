
下面是 circle 所能找到的可能问题：

1. goodTuples
2. deleteMinimalPeaks
3. scheduleCalendarInvite
4. obtainUniqueSequence

` 1/4 最简单，2/3 最难`

---

1. checkOperations

2. equallyRearranging

3. figureUnderGravity

4. Suffix pairs 

---

1. 题目：goodTuples

Give an array and find the count of a pair number and a single number combination in a row of this array. Target array is a[​i - 1], a[​ i], a[​ i + 1]

Input: a = [1, 1, 2, 1, 5, 3, 2, 3]

Output: 3

Explain:

[1, 1, 2] -> two 1 and one 2(O)

[1, 2, 1] -> two 1 and one 2(O)

[2, 1, 5] -> one 2, one 1 and one five(X)

[1, 5, 3] -> (X)

[5, 3, 2] -> (X)

[3, 2, 3] -> (O)

Time: O(n)

题意：给定一组 array，要求找出一对 pair 和另一个单独数字的组合。

这道题题意应该很直观，因为已经指定了要求的 array 必须是三个连续的数字

Python 解法如下：

```Python

def solve():
    arr = [1, 1, 2, 1, 5, 3, 2, 3]
    length = len(arr)

    cnt = 0
    for i in range(length-2):
        if is_pair(arr[i],arr[i+1],arr[i+2]):
            cnt += 1
    
    return cnt

def is_pair(a,b,c):
    if a==b and b==c:
        return False
    if a==b or a==c or b==c:
        return True
    
    return False

```

2. 题目：deleteMinimalPeaks

给一个 array，要求找出 minimal peak，然后把 minimal peak 放到新的
array 重新排一次

对 minimal peak 定义：`(A[i]>A[i+] 或 A[i+1]不存在)` 且 `(A[i]>A[i-1] 或 A[i-1] 不存在`

input : 4 2 5 3 7 9

output : 第一步找出最小 peak 是 4，然后把 4 移出，新的 array 变成
`2 5 3 7 9`，result 的 array 第一个数字是 4.

input :  1 4 5 3 8 6 
[1,4,5,3,8,6], Min peak = 5, resultant = [1,4,3,8,6]
[1,4,3,8,6], Min peak = 4, resultant = [1,3,8,6]
[1,3,8,6], Min peak = 8, resultant = [1,3,6]
[1,3,6], Min peak = 6, resultant = [1,3]
[1,3], Min peak = 3, resultant = [1]
[1], min peak = 1
Output = [5,4,8,6,3,1]

如此循环一直到 sort 完一整个 input array

这道题竟然是 hard 难度的...

和 https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/ 很像，是怎么像的？

Python 解法如下：

具体细节还需要再掌握

```Python

### Use this space to try out ideas and free code ###

from heapq import heappush,heappop

def deleteMinPeak():
    arr = [2, 7, 8, 5, 1, 6, 3, 9, 4]
    length = len(arr)

    queue = []
    left,right = [0]*length,[0]*length
    for i in range(length):
        left[i] = i-1
        right[i] = i+1
    
    for i in range(length):
        if isPeak(arr,i,left,right):
            heappush(queue,[arr[i],i])
    
    res = []
    print(queue)
    
    while queue:
        curr,index = heappop(queue)
        res.append(curr)
        # next is to judge whether removing this value can generate
        # new peak
        l = left[index]
        r = right[index]
        
        if r<=length-1:
        	left[r]=l
        if l>=0:
        	right[l]=r
        
        if isPeak(arr,l,left,right):
            heappush(queue,[arr[l],l])
        
        if isPeak(arr,r,left,right):
            heappush(queue,[arr[r],r])
        
    return res
    

def isPeak(arr,index,left,right):
    # use left/right to judge the boundary
    if index<0 or index>len(arr)-1:
      return False

    if (left[index]==-1 or arr[index]>arr[left[index]]) and (right[index]==len(arr) or arr[index]>arr[right[index]]):
        return True
    return False


if __name__=='__main__':
    res = deleteMinPeak()
    print(res)

```

3. 关于 MeetingSchedule ，可能是下面这个相似的问题：

https://leetcode.com/discuss/interview-question/490962/Design-Meeting-Scheduler

4. 关于 obtainUniqueSequence 就是 LC 945
Minimum Increment to Make Array Unique

---

1. 关于 Check operations 应该是这道题：

```
You are given three arrays of integers a , b , and c 
and an array of characters signs consisting of '+' and signs. 

All of these arrays have the same length. 

1.1 Your task is to return a boolean array output of the same length, where output[i] = true if the result of applying signs[i] to a[i] and b[i] is equal to c[i] , and false otherwise.

In other words, for each index i, check if a[i] signs[i] b[i] c[i]. Example 

For a = [3, 2, -1, 4], 
signs = ['+','-', '-', '+'], 
b = [2, 7, -5, 2] , 
and c = [5, 5 4, 2] , 

the output should be checkoperations(a, signs, b, c) [true, false, true, false]

```

这道题应该挺直观的...直接按照下面解法来就好：

```Python


def solve():
    a = [3, 2, -1, 4]
    signs = ['+','-', '-', '+']
    b = [2, 7, -5, 2]
    c = [5, 5,4, 2] 

    length = len(a)
    res = [False]*length

    for i in range(length):
        target = a[i]+b[i] if signs[i]=='+' else a[i]-b[i]
        res[i] = (target==c[i])

    print(res)

```



2. 关于 Equally Rearranging 应该是下面这道题：

https://www.chegg.com/homework-help/questions-and-answers/please-complete-python3-explain-thoroughly-thanks-given-string-str-containing-letters-w-d--q85546563

这里有一个解法：https://github.com/mehrotrasan16/bits-n-pieces/blob/master/square-equallyrearranging-codesignal.py

Python 解法如下，使用 Counter 就很直观：

```Python

from collections import Counter

def solve():
    input_ = "DLDD"

    counter = Counter(input_)

    res = []
    cnt = len(input_)

    while cnt>0:
        for ch in "WDL":
            if counter[ch]>0:
                res.append(ch)
                counter[ch]-=1
                cnt-=1
    print("".join(res))

if __name__ == '__main__':
    solve()

```

3. Figure under gravity 应该是下面这道题：

grid 上有一个不规则形状的图形，上面有三种格子：
` # 表示障碍`
` . 表示空`
` F 表示图形上的一个像素`

在重力作用下，图形从当前位置掉落后，新生成的 Grid 是什么样？

You are given a rectangular matrix of characters matrix, which represents a 2-dimensional field where each cell is either empty ('.'), contains an obstacle (#), or corresponds to a cell of a connected figure ('F').
Gravity makes the figure fall through the field, until one of its cells reaches the ground, or meets an obstacle. Your task is to return the state of the field after the figure has fallen.
Note that it is guaranteed that the figure is connected, ie. between any two cells of the figure there exists a path which goes through the cells' sides (not through corners).

假设 input 为：

[
['F','F','F'],
['.','F','.'],
['.','F','F'],
['#','F','.'],
['F','F','.'],
['.','.','.'],
['.','.','#'],
['.','.','.']
]
 
那么希望 Output 为:

[
['.','.','.'],
['.','.','.'],
['F','F','F'],
['#','F','.'],
['.','F','F'],
['.','F','.'],
['F','F','#'],
['.','.','.']
]

有一个讨论在这里：
https://leetcode.com/discuss/interview-question/1202083/Databricksor-Online-Assessment-or-FigureUnderGravity

我个人的这种解法应该是没有问题的：

```Python

def solve():
    grid = [['F','F','F'],
    ['.','F','.'],
    ['.','F','F'],
    ['#','F','.'],
    ['F','F','.'],
    ['.','.','.'],
    ['','','#'],
    ['','.','']]

    """
    find max_distance of possible fall-down

    """
    figures = []
    obstacles = defaultdict(list)
    row,column = len(grid),len(grid[0])
    max_falldown = row-1

    for i in range(row):
        for j in range(column):
            if grid[i][j]=='#' or i==row-1:
                obstacles[j].append(i)

    for i in range(row):
        for j in range(column):
            if grid[i][j]=='F':
                figures.append((i,j))
                fall_index = bisect.bisect_left(obstacles[j],i)
                max_falldown = min(max_falldown,fall_index-i-1)
    
    for x,y in figures[::-1]:
        grid[x][y]='.'
        grid[x+max_falldown][y]='F'
    
    return grid

```

同时因为 obstacle 是在一个 column 上从上到下排列，所以显然可以用二分搜索来优化：

Python 解法如下：

```Python

from collections import defaultdict
import bisect

def solve():
    grid = [['F','F','F'],
    ['.','F','.'],
    ['.','F','F'],
    ['#','F','.'],
    ['F','F','.'],
    ['.','.','.'],
    ['','','#'],
    ['','.','']]

    """
    find max_distance of possible fall-down

    """
    figures = []
    obstacles = defaultdict(list)
    row,column = len(grid),len(grid[0])
    max_falldown = row-1

    for i in range(row):
        for j in range(column):
            if grid[i][j]=='#' or i==row-1:
                obstacles[j].append(i)
    
    for i in range(row):
        for j in range(column):
            if grid[i][j]=='F':
                figures.append((i,j))
                obs = obstacles[j]
                stop_index = bisect.bisect_left(obs,i)
                max_falldown = min(max_falldown,obs[stop_index]-i-1)
    
    for x,y in figures[::-1]:
        grid[x][y]='.'
        grid[x+max_falldown][y]='F'
    
    return grid

```

同时发现这样一个链接：
https://github.com/yiweit/Practice/blob/6a011192665365c0ec9df9b82d670d2496bed0f7/Python/DatabricksOA_FigureUnderGravity.py

感觉是一种更优化的选择？后续看看。

4. Suffix Pairs :

题目如下：

Given an array of Strings,your task is to find the number
of pairs which one is a suffix of other string

比如 input=["cba","a","a","b","ba","ca"]

output =
[cba,a] // a 是 cba 的一个 suffix
[cba,a]
[cba,ba]
[a,a]
[ba,a]
[ca,a]
[a,ba]
[a,ca] // > 这里是怎么得出来的

cba,a
cba,a
cba,ba
a,a
ba,a
ca,a
ba,a
ca,a

参考：https://leetcode.com/discuss/interview-question/1301919/Robinhood-or-OA-or-Suffix-pairs

这道题感觉还蛮有难度的，基本思路是用 `Trie` 来解决：
但是具体细节怎么做，让我慢慢看下：

Python 解法如下：

下面的解法远远不是最优雅的，对有重复数字，比如
['a','a'] 的处理，在第一次循环时候会得到 (['a','a']) 这样的
pair，在第二次循环的时候也会得到 (['a','a']) 的 pair，自己在下面的
函数里实现了一个 extra_count() 来处理，但应该有更好的处理方式。

```Python

from collections import Counter

input_=["cba","cba","a","a","b","ba","ca"]

class TrieNode(object):
    def __init__(self):
        self.children = {}
        self.word = None
        self.freq = 0 # used to handle duplicates

class Trie(object):
    def __init__(self):
        self.root = TrieNode()
    
    def add_word(self,word):
        curr = self.root
        for ch in word:
            if ch not in curr.children:
                curr.children[ch] = TrieNode()
            curr = curr.children[ch]
        curr.freq += 1
        curr.word = word[::-1]

def count(root,word):
    """ return int value """
    count = 0
    # if root.freq!=0:
    #     count += freq
    for ch in word[::-1]:
        root = root.children[ch]
        if root.freq!=0:
            if root.word==word:
                count += root.freq-1
            else:
                count += root.freq

    return count

def extra_count(arr):
    s = Counter(arr)
    count = 0
    for val,freq in s.most_common():
        if freq>1:
            sum_ = 1
            for i in range(1,freq+1):
                sum_*=i
            count +=(sum_-1)
    return count
    
def solve():
    trie = Trie()
    for word in input_:
        trie.add_word(word[::-1])
    res = 0
    for word in input_:
        res += count(trie.root,word)
    res -= extra_count(input_)
    return res

if __name__=='__main__':
    print(solve())

```

---

1. 给一个 integer，求所有数字的乘积减去 sum：

input :12345
output:1*2*3*4*5-(1+2+3+4+5)

Python 解法如下：

```Python

def solve():
  num = 12345
  sum1,sum2 = 1,0
  
  while num:
    extra = num%10
    sum1 *= extra
    sum2 += extra
    num = num//10
  
  return sum1-sum2

```

2. 2. input: int n,int m,array

n,m 是一个 2D array 的长度 length，然后一个 array 是一堆数字，数字仅
包含 1-5，每个数字代表一个图案。例如 1 是一个点一个格子，2 是 T 字型 6 
个格子。

最后按顺序把图案放到 n,m 的 2D array。如果图案相撞会加数字 最后 return 
那个 2D array

// 只看描述应该不难，大概思路如下：

```Python

shapes = {
    1:[(0,0)],
    2:[(0,1),(1,0)],
    3:[(0,1),(1,2),(2,3)]
}

res = [[0]*m for _ in range(n)]

for figure in fugres:
    for x,y in shapes:
        res[x][y] += score

return res
```

Anyway 明天时候再看吧，大概应该就这几步，不再想这道题了。

3. Number of pairs in queries 

https://leetcode.com/discuss/interview-question/952899/codesignal-online-assessment-number-of-pairs-in-queries

input 有 3 个 array: `a[]`,`b[]`,`arr[][]`

a,b 都是一个包含 integer 的普通 array
然后 arr[][] 的格式是 [[0,x],[1,f,g],[0,x]...[]]，
arr[][] 里面的 sub list 有 2 个 format:

a. [0,i,j] 需要更新 B[i]=j
b. [1,k] 说明需要从 A 中找出一个数字，从 B 中找出一个数字，组成一个 pair 
使 sum 总和为 k

The number in a and b is guaranteed to be greater than or equal to 0.
For example:
a = [1,2,3]
b = [2,4]
query = [[1,5], [0, 0, 1], [1, 5]]
For the first query, [1, 5], we can find 2 pairs, (1,4) and (3,2)
For the second query, we update b[0] = 1, so now b = [1,4]
For the third query, we can only find one pair to sum up to 5, which is (1,4)

最后 return 一个 array，就是 return 所有 `b` 的结果

感觉基本就是 `2 sum` 的变种，a 保持不变就对 `a` 用 counter 来计数

Python 解法如下：

```Python

from collections import Counter

def solve():
    a = [1,2,3]
    b = [2,4]

    query = [[1,5], [0, 0, 1], [1, 5]]
    res = []

    hashmap = Counter(a)
    res = 0

    for q in query:
        if q[0]==1:
            target = q[1]
            cnt = 0
            for b_val in b:
                    cnt += hashmap[target-b_val]
            res += cnt
        else:
            _,i,j = q
            b[i] = j
    
    return res

if __name__=='__main__':
    solve()

```

4. 还有一道题应该是下面这道：

https://leetcode.com/discuss/interview-question/842141/Databricks-OA

上面这道题算了...好像不是一道题

5. 以及这道题也出现了：

https://leetcode.com/discuss/interview-question/1536912/Databricks-OA

```
Given an infinite number line, two types of operations: [1, x] - builds an obstacle at coordinate x along the number line. It is guaranteed that coordinate x does not contain any obstacles when the operation is performed. [2, x, size] - checks whether it's possible to build a block occupying coordinates between x, x + 1, ..., x + size - 1 along the number line. Returns 1 if it is possible, i.e. there are no obstacles at the occupied coordinates, and return 0 otherwise.
```

这道题就是最后一道题了，思路是用 segment tree 来存储所有 obstacle 的坐标然后用
`range query()` 来获得是否有 obstacle 在里面。

今天晚上这就是最后一道需要自己实现的题。然后复习一下再去做 sliding window.



---

1. 

第二题
找出array里第一个为零的数字 存成temp 找到之后设为０，往后继续看，如果比temp大的话就减去，如果比temp小，把当前的temp 加到result  并从头开始算，直到整个array 为零 输出result
testcase : [3,3,5,2,3]
res: 6. (3+2+1)

sample [3,3,5,2,3]

[0,0,2,2,3] res = 3
[0,0,0,0,1] res = 3 + 2
[0,0,0,0,0] res = 3 + 2 + 1

应该是这道题：
https://www.chegg.com/homework-help/questions-and-answers/java-language-please-given-numbers-array-non-negative-integers-task-perform-following-algo-q66403696

这道题 Python 解法如下：

```Python

def solve():
    """
    sample [3,3,5,2,3]

    [0,0,2,2,3] res = 3
    [0,0,0,0,1] res = 3 + 2
    [0,0,0,0,0] res = 3 + 2 + 1
    """
    input_ = [3,3,5,2,3]
    length = len(input_)

    index = res = 0
    while index<length:
        i = index
        while i<length and input_[i]==0:
            i += 1
        index = i+1
        if i<length:
            target = input_[i]
            res += target
            while i<length and input_[i]>=target:
                input_[i]-=target
                i+=1
    return res

```


第三‍‌‍‍‌‌‌‌‍‍‍‍‍‍‍‍‍‍‍‍题
其他人有提过写过了 输出报纸 对话筐对齐

对话框对其应该是这道题：
https://www.chegg.com/homework-help/questions-and-answers/imagine-conversation-two-users-chat-app-given-two-dimensional-string-array-messages-repres-q83836186

Python 解法如下：

基本就是下面的流程，具体的一些细节还有待挖掘：

```Python

messages = [["1","Hello how r u"],["2","good ty"],
["2","u"],["1","me too bro"]]

width,user_width = 15,5

def solve():

    res = []
    for message in messages:
        user,content = message
        arr = content.split(" ")
        temp = []
        curr_length = 0
        index = 0
        while index<len(arr):
            new_length = curr_length + len(arr[index])
            if curr_length!=0:
                new_length += 1
            if new_length<=user_width:
                curr_length = new_length
                temp.extend([" ",arr[index]])
                index += 1
            else:
                res.append([user,"".join(temp).strip()])
                curr_length = 0
                temp = []
        if temp:
            res.append([user,"".join(temp).strip()])

    for x in _generate_content(res,width):
        print(x)

def _generate_content(array,width):
    
    bar = '+'+ ''.join(['*']*width)+'+'
    res = []
    res.append(bar)
    for user,message in array:
        if user=='1':
            temp = message + ''.join([' ']*(width-len(message)))
        else:
            temp = ''.join([' ']*(width-len(message))) + message
        res.append('|'+temp+'|')
    res.append(bar)

    return res


if __name__=='__main__':
    solve()


```