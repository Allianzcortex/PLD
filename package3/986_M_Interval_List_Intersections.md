
Problem description:

```

You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].



Example 1:


Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Example 2:

Input: firstList = [[1,3],[5,9]], secondList = []
Output: []
Example 3:

Input: firstList = [], secondList = [[4,8],[10,12]]
Output: []
Example 4:

Input: firstList = [[1,7]], secondList = [[3,10]]
Output: [[3,7]]

```

---

Basic idea:

使用 two pointers 解法，每次比较 i,j 对应的 end 决定哪一个去 + 1

而判断两个 list 是否有重合的代码是：`if startA<=endB and startB<=endA`


Python 代码如下：

```Python

class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        
        len1,len2 = len(firstList),len(secondList)
        i,j = 0,0
        res = []
        
        while i<len1 and j<len2:
            startA,endA = firstList[i]
            startB,endB = secondList[j]
            
            if startA<=endB and startB<=endA:
                res.append([max(startA,startB),min(endA,endB)])
            
            if endA<=endB:
                i+=1
            else:
                j+=1
        
        return res

```

---

Java 代码如下：

```Java

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int lenA=A.length,lenB=B.length;
        int i=0,j=0;
        List<int[]> res = new ArrayList<>();
        
        while(i<lenA && j<lenB) {
            int startA = A[i][0],endA = A[i][1];
            int startB = B[j][0],endB = B[j][1];
            
            if(startA<=endB && startB<=endA) {
                res.add(new int[]{Math.max(startA,startB),Math.min(endA,endB)});
            }
            
            if(endA<=endB)
                i+=1;
            else
                j+=1;
        }
        
        int[][] output = new int[res.size()][2];
        for(i=0;i<res.size();i++) {
            output[i][0]=res.get(i)[0];
            output[i][1]=res.get(i)[1];
        }
        
        return output;
    }
}

```

Golang 代码如下：

```Golang

func intervalIntersection(firstList [][]int, secondList [][]int) [][]int {
    
    res := make([][]int,0)
    i,j := 0,0
    
    for i<len(firstList) && j<len(secondList) {
        maxLeft := max(firstList[i][0],secondList[j][0])
        minRight := min(firstList[i][1],secondList[j][1])
        
        if maxLeft<=minRight {
            res = append(res,[]int{maxLeft,minRight});
        }
        
        if(firstList[i][1]<secondList[j][1]) {
            i+=1;
        } else {
            j+=1;
        }
    }
    
    return res;
    
}

func max(a,b int) int {
    if(a>b) {
        return a;
    }
    
    return b;
}

func min(a,b int) int {
    if(a<b) {
        return a;
    }
    
    return b;
}

```
