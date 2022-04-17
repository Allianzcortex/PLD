
Problem description:

```

Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y. Also two strings X and Y are similar if they are equal.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

We are given a list strs of strings where every string in strs is an anagram of every other string in strs. How many groups are there?

 

Example 1:

Input: strs = ["tars","rats","arts","star"]
Output: 2
Example 2:

Input: strs = ["omv","ovm"]
Output: 1
 

Constraints:

1 <= strs.length <= 300
1 <= strs[i].length <= 300
strs[i] consists of lowercase letters only.
All words in strs have the same length and are anagrams of each other.

```

Basic idea:

这道题是要把很多单词连接起来，就是很典型的 `Union Find` 使用场景

关键两点：

1. 判断两个单词是否连通，比较 diff 的数量，只能为 0/2

2. 对 Union Find，用 `union by rank` 和 `path compression` 来压缩

参考：

https://algorithms.tutorialhorizon.com/disjoint-set-union-find-algorithm-union-by-rank-and-path-compression/

和

https://algorithms.tutorialhorizon.com/disjoint-set-data-structure-union-find-algorithm/

Python 代码如下：

```Python


class UnionFind(object):
    
    def __init__(self,n):
        
        self.parent = list(range(n))
        self.rank = [0]*n
    
    def find(self,n):
        while n!=self.parent[n]:
            n = self.parent[n]
        
        return n
    
    def union(self,x,y):
        root1 = self.find(x)
        root2 = self.find(y)
        
        if root1==root2:
            return
        
        if self.rank[root1]>self.rank[root2]:
            self.parent[root2] = root1
        else:
            self.parent[root1] = root2
        
        if self.rank[root1]==self.rank[root2]:
            self.rank[root1] += 1
    

class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        n = len(strs)
        u = UnionFind(n)
        
        for i in range(len(strs)):
            for j in range(i+1,len(strs)):
                if self._is_similar(strs[i],strs[j]):
                    u.union(i,j)
        
        return len(set(u.find(i) for i in range(n)))
    
    def _is_similar(self,x,y):
        if len(x)!=len(y):
            return False
        
        diff = 0
        for i,ch in enumerate(x):
            if ch != y[i]:
                diff += 1
        
        return diff==0 or diff==2

```