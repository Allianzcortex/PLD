
Problem description:

```

Given an array of integers arr of even length, return true if and only if it is possible to reorder it such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2.

 

Example 1:

Input: arr = [3,1,3,6]
Output: false
Example 2:

Input: arr = [2,1,2,6]
Output: false
Example 3:

Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
Example 4:

Input: arr = [1,2,4,16,8,4]
Output: false
 

```

Idea : 这道题自己一开始的想法是正确的，就是要先排序，然后这里的关键是对正负数的处理：

排序完后最小的数在第一位，然后：

a. 如果这个数是正数，那么能和它匹配的一定是 val*2

b. 如果这个数是负数，那么能和它匹配的一定是 val/2 (比如 -4，它只能和 -2 匹配，不能和 -8 匹配，
因为它已经是最小了，不存在比它更小的值)

然后依此迭代，并用一个 counter 来处理出现的次数

Python 代码如下：

```Python

class Solution:
    def canReorderDoubled(self, arr: List[int]) -> bool:
        """
        1 2 4 4 8 16
        """
        
        arr.sort()
        
        cnt = {}
        index = 0
        
        for i,val in enumerate(arr):
            cnt[val] = cnt.get(val,0) + 1
        
        for i,val in enumerate(arr):
            
            if cnt[val] == 0:
                # it has been countered once
                continue

            if val>0:
                target = val*2
            else:
                target = val // 2
                if val % 2 !=0:
                    return False

            if target not in cnt or cnt[target]<=0:
                return False
            else:
                cnt[target] -= 1
                cnt[val] -= 1
            
        return True

```

对应的 Golang 解法如下：

```Go

import "sort"

func canReorderDoubled(arr []int) bool {
    
    sort.Ints(arr)
    
    count:=make(map[int]int)
    
    // build the map
    for _,x:=range arr {
        count[x] += 1
    }
    
    // traverse through the slice
    
    for _,x := range arr {
        
        if (count[x] == 0 ){
            continue
        }
        
        var target int
        
        if (x >0 ) {
            target = x*2
        } else {
            target = x/2
            if x%2 != 0 {
                return false
            }
        }
        
        if(count[target]<=0) {
            return false
        }
        
        count[target]-=1
        count[x]-=1
        
    }
    
    return true

}


```