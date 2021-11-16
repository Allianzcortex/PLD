
下面是 circle 所能找到的可能问题：

1. goodTuples
2. deleteMinimalPeaks
3. scheduleCalendarInvite
4. obtainUniqueSequence

` 1/4 最简单，2/3 最难`

---

1. 给一个 integer，求所有数字的乘积减去 sum：

input :12345
output:1*2*3*4*5-(1+2+3+4+5)

3. input: int n,int m,array

n,m 是一个 2D array 的长度 length，然后一个 array 是一堆数字，数字仅
包含 1-5，每个数字代表一个图案。例如 1 是一个点一个格子，2 是 T 字型 6 
个格子。

最后按顺序把图案放到 n,m 的 2D array。如果图案相撞会加数字 最后 return 
那个 2D array

4. input 有 3 个 array: `a[]`,`b[]`,`arr[][]`

a,b 都是一个包含 integer 的普通 array
然后 arr[][] 的格式是 [[0,x],[1,f,g],[0,x]...[]]，
arr[][] 里面的 sub list 有 2 个 format:

a. [0,x]，就是求有多少 pair x=a+b[j] ，也就是求有多少对 2sum
b. [1,f,g] 就是做如下操作：
a[f]=a[f]+g 所以 a 里面的数字会动态变化

最后 return 一个 array，就是 return 所有 [0,x] 的结果

---

1. checkOperations

2. equallyRearranging

3. figureUnderGravity

4. Suffix pairs 

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

第三‍‌‍‍‌‌‌‌‍‍‍‍‍‍‍‍‍‍‍‍题
其他人有提过写过了 输出报纸 对话筐对齐

对话框对其应该是这道题：
https://www.chegg.com/homework-help/questions-and-answers/imagine-conversation-two-users-chat-app-given-two-dimensional-string-array-messages-repres-q83836186

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

1. 关于 integer sum 求解部分，再看吧。

---

1. 关于 Check operations 应该是这道题：

```
You are given three arrays of integers a , b , and c 
and an array of characters signs consisting of '+' and signs. 

All of these arrays have the same length. 

1.1 Your task is to return a boolean array output of the same length, where output[i] = true if the result of applying signs[i] to a[i] and b[i] is equal to c[i] , and false otherwise.

In other words, for each index i, check if a[i] signs[i] b[i] c[i]. Example 

For a = [3, 2, -1, 4], 
signs = ['t', '-', '+'], 
b = [2, 7, -5, 2] , 
and c = [5, 5 4, 2] , 

the output should be checkoperations(a, signs, b, c) [true, false, true, false]

```



2. 关于 Equally Rearranging 应该是下面这道题：

https://www.chegg.com/homework-help/questions-and-answers/please-complete-python3-explain-thoroughly-thanks-given-string-str-containing-letters-w-d--q85546563

这里有一个解法：https://github.com/mehrotrasan16/bits-n-pieces/blob/master/square-equallyrearranging-codesignal.py

3. Figure under gravity 应该是下面这道题：

grid 上有一个不规则形状的图形，上面有三种格子：
` # 表示障碍`
` . 表示空`
` F 表示图形上的一个像素`

在重力作用下，图形从当前位置掉落后，新生成的 Grid 是什么样？

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