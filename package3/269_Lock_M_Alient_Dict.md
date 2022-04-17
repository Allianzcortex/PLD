
Problem description:

```
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
Example 1:
Given the following words in dictionary,
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".
Example 2:
Given the following words in dictionary,
[
  "z",
  "x"
]
The correct order is: "zx".
Example 3:
Given the following words in dictionary,
[
  "z",
  "x",
  "z"
]
The order is invalid, so return "".
Note:
You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.

```

Idea : 这道题如果是第一次看的话确实不太好想出思路

其实是一道 Topological Sort 题，以第一个为例：

```
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
```
首先找出所有的 character ,并都设置入度为 0.
然后依次遍历 (0,1),(1,2),(2,3) 单词：

对 (0,1):它是 "wrt"->"wrf"，前两个都是 "wrt" 所以跳过，第三个是 "t->f" 意味着
t 的优先级比 f 高，所以建立一个 t->f 的连接，并把 indegrees[f]+=1

```
if d not in adj_list[c]:
adj_list[c].add(d)
indegrees[d]+=1
```

对 (1,2):它是 "wrf"->"er"，两个长度分别为 3/2，所以我们选择 2.对前两个字符，我们建立连接：
"w->e"

之后依此类推，使用拓朴排序：

Python 代码如下：`有时间的时候需要解锁这道题然后再实现一遍`：

```Python

class Solution:
    def alienOrder(self, words: List[str]) -> str:
        # create adject matrx of the graph
        adj_list = collections.defaultdict(set)
        # create initial indegrees 0 for all distinct words
        indegrees = {}
        for word in words:
            for c in word:
                if c in indegrees:
                    continue
                indegrees[c] = 0
        
        # construct the graph and indegrees
        for first_word,second_word in zip(words,words[1:]):
            for c,d in zip(first_word,second_word):
                if c!=d:
                    # this line is needed, otherwise the indegrees of d will be repeatedly added
                    if d not in adj_list[c]:
                        adj_list[c].add(d)
                        indegrees[d]+=1
                    break
            # this 'else' will still match with the 'if' inside the for loop, it means if after any zip pairs c and d is not equal, codes in 'else' won't be runned. only when all pairs are equal, then codes in 'else' will be runned. In other words, the 'else' match to the final 'if' of the for loop
            else:
                # check if the second word is a prefix of the first word
                if len(second_word)<len(first_word):
                    return ''
        
        # pick all nodes with zero indegree and put it into queue
        q = collections.deque()
        for k,v in indegrees.items():
            if v==0:
                q.append(k)
        
        # pick off zero indegree nodes level by level,and add to the output
        ans = []
        while q:
            c = q.popleft()
            ans.append(c)
            for d in adj_list[c]:
                indegrees[d] -= 1
                if indegrees[d]==0:
                    q.append(d)
        
        # if there are letter that not appear in the output, means there is a cycle in the graph, because on the indegrees of nodes in a cycle will all be non-zero
        if len(ans)<len(indegrees):
            return ''
        
        return "".join(ans)


```
