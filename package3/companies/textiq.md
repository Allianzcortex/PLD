
Basic idea :

textiq 基本有 3 道 OA 题：

```
1. Lexicographically all Shortest Palindromic Substrings from a given string
2. Given a BST, replace each node's value with the sum of the values of all the nodes that are greater than that ‍‌‍‍‌‌‌‌‍‍‍‍‍‍‍‍‍‍‍‍node.
3. Find a Sum of Fractions
```

---

第一道题目对应的是：

https://www.geeksforgeeks.org/lexicographically-all-shortest-palindromic-substrings-from-a-given-string/

直接用 Python 的 `sorted(set(s))` 就可以得到结果，或者用 array[26]
然后 `ord(ch)-ord('a')` 得到 index

---


第二道题目对应的是：

LC 的这道题

1038. Binary Search Tree to Greater Sum Tree

https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

√ 基本思路是用 reverse inorder traverse 在遍历树的过程中加入新的值

---

第三道题目对应的是：

可能的 LC 题目：

592 Fraction Addition and Subtraction

https://leetcode.com/problems/fraction-addition-and-subtraction/

对应的解法是：

1. 按照 `+/-` 来分割得到分子
2. 按照分数加减法来计算
3. 最后根据 `gcd` 得到最大公约数来化简

---

以及另外一道 OA 题是关于字符串处理：

```
Given a string S find an output string adhering to the following rules:
1.output string must read the same backwards as forwards 
2.output string must be of the same length as the input string 
3.output string must be greater than or equal to s according to alphabetical order. The difference between s and the output string must be as small as possible in terms of alphabetical order.
4.strings contain only lowercase English letters.
Examples: cbada   -> cbabc,   abcbc -> abdba,   xgdfcs -> xgeegx

```

这道题在这个链接里有陈述：https://cs.stackexchange.com/questions/136490/finding-the-lexicographically-smallest-palindrome-of-the-same-length-that-is-lex/145255#145255

要求输出的数满足两个要求：

1. 同长度且回文
2. 比原始数组在 alphabet 的序列上大且要最小化大的程度

自己思路如下：

对奇偶分开讨论，但不管怎么分开，原始字符都会被划分为两部分：left 和 right

- 如果 reverse(left) 小于 right，就说明如果按照 left+reverse(left) 的方式生成
新的回文字符串，是会比原来的部分大的，这就是我们需要的答案

- 如果 reverse(left) 并不小于 right，就说明我们需要更改 left 部分，生成一个比 left 大一位
的 new_left，之后再按照 new_left + reverse(new_left) 的方式返回需要的字符串

    - 而要生成比 left 大一位的 new_left，我们用一个单独的函数来处理它，如果这个字符为 `z`,我们知道
它需要被变为 `a`，继续减少前一位；如果它不是 `z`，我们只需要让它减 1 就好

Python 代码如下：

```Python

def increase_one(input_):
    s = list(input_)
    for i in range(len(s)-1,-1,-1):
        if s[i]=='z':
            s[i]='a'
        else:
            s[i]=chr(ord(s[i])+1)
            break
    return ''.join(s)

def run(string):
    if not string:
        return ""
    
    if string==string[::-1]:
        return string

    length = len(string)    
    index = length//2

    if length%2==1:
        left,right = string[:index],string[index+1:]
        if right<left[::-1]:
            return left+string[index]+left[::-1]
        else:
            new_left = increase_one(string[:index+1])
            return new_left+new_left[:-1][::-1]
    else:
        left,right = string[:index],string[index:]
        if right<left[::-1]:
            return left+left[::-1]
        else:
            new_left = increase_one(left)
            return new_left+new_left[::-1]
        
if __name__=='__main__':
    print(run('cbaba'))    # cbabc
    print(run('abcbc'))    # abdba
    print(run('xgdfcs'))   # xgeegx
    print(run('aazzzzba')) # abaaaaba
    print(run('aiyudauzzzzuaduyie')) # aiyudavaaaavaduyia

```

---

另外还有一道飞机场降落的题目如下：

```

Today is a busy day at XXX Airport. There are a lot of airplanes requesting to land but unfortunately, there is only 1 available runway for landing. As a result, a policy has been set to manage the landing aircrafts:
Landing requests are processed in the order they are received.
A landing request is accepted if the runway is free, and the landing process can start immediately.
Once a landing request is accepted, the flight takes some time to finish landing.
A landing request is temporarily rejected if there is no free runaway available. The requesting aircraft is asked to request to land again after 10 minutes.
If two airplanes request to land at the same time, the request from the one with the smaller flight number will be processed first.

Your task is:
Write a program that, g‍‍‌‌‌‍‌‍‌‍‍‌‌‌‍‌‍‍iven a list of the flight number + landing request time + landing duration time, simulates the above process and generates a chronological report of when each flight is ACCEPTED, POSTPONED or has LANDED.

Sample Input (flight number, landing request timestamp, landing duration time)
377 45 10
367 45 5
357 50 5
347 51 15

Sample Output
45 367 ACCEPTED
45 377 POSTPONED
50 367 LANDED
50 357 ACCEPTED
51 347 POSTPONED
55 357 LANDED
55 377 ACCEPTED
61 347 POSTPONED
65 377 LANDED
71 347 ACCEPTED 
86 347 LANDED

```

这道题一看就很明显是 `pq` 的用法，要注意的思路如下：

- 比如在 `time_a` 有一架飞机降落并且 accepter，用时为 `duration_a`，那么在从
`[time_a,time_a+duration_a)` 这段时间内所有发出降落请求的飞机都会被拒绝，我们只需要存储所有需要
降落的飞机，记住它们发出请求的时间，加到 `pq` 里并和 `time_a+duration_a` 比较，就可以得出所有飞机的
降落顺序

- 至于存储的结果，我们可以用一个 `defaultdict` 来存储。如果 `time_a` 飞机 `accepted`，那么
`time_a+duration_a` 必然该飞机 `landed`；如果 `time_b` 该飞机小于 `time_a+duration_a`，那么该飞机
必然被 `reject`，并会在 `time_b+10` 的时间点加入一个新的降落请求

对此 Python 代码如下：

```Python


from heapq import heappush,heappop
from collections import defaultdict

input_ = [
(377,45,10),
(367,45,5),
(357,50,5),
(347,51,15)]

def run():
    res = defaultdict(list)
    queue = []
    for flight in input_:
        # 需要按照 (时间,航班号) 加入最小堆
        heappush(queue,(flight[1],flight[0],flight[2]))
    
    start_time = -1
    end_time = -1

    while queue:
        if queue[0][0]>=end_time:
            curr = heappop(queue)
            time,number,duration = curr
            start_time = time
            end_time = time+duration
            res[start_time].append([number,"ACCEPTED"])
            res[end_time].append([number,"LANDED"])
        else:
            temp = []
            # 注意范围，一定是 `[time_a,time_a+duration_a)`
            while queue and start_time<=queue[0][0]<end_time:
                temp.append(heappop(queue))
            for flight in temp:
                time,number,duration = flight
                res[time].append([number,"POSTPONED"])
                heappush(queue,(time+10,number,duration))
  
    output = []
    for time,actions in res.items():
        for action in actions:
            output.append([time,action[0],action[1]])
    output.sort(key = lambda item:(item[0],item[1]))
    for item in output:
        print(f"{item[0]} {item[1]} {item[2]}")

if __name__=='__main__':
  run()

```