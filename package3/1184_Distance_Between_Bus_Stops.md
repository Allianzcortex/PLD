
Problem description:

```

A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.

The bus goes along both directions i.e. clockwise and counterclockwise.

Return the shortest distance between the given start and destination stops.

 

Example 1:



Input: distance = [1,2,3,4], start = 0, destination = 1
Output: 1
Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.

```

basic idea : 

这道题基本思路很固定，就是顺时针和逆时针的计算，Python 解法如下：

```Python

class Solution:
    def distanceBetweenBusStops(self, distance: List[int], start: int, destination: int) -> int:
        
        dis1,dis2 = 0,0
        start,end = min(start,destination),max(start,destination)
        new_start,new_end = start,end
        # calculate clockwise direction
        while start<end:
            dis1+=(distance[start])
            start += 1
        
        # calculate anti-clockwise direction
        while new_start!=new_end:
            dis2+=(distance[new_end])
            new_end = (new_end+1)%(len(distance))
        
        return min(dis1,dis2)

```

但上面的解法显然太复杂了，只要注意到顺时针+逆时针距离加起来是一整个的路径，那么只用循环一次就可以，Golang 解法如下：

```Golang

func distanceBetweenBusStops(distance []int, start int, destination int) int {
    
    res,sum:=0,0
    hasReached:=false
    start,end := min(start,destination),max(start,destination)
    for i:=0;i<len(distance);i++ {
        if(start==end) {
            hasReached=true
        }
        if(!hasReached){
           res+=distance[start]
        }
        
        sum+=distance[start]
        start=(start+1)%(len(distance))
    }
    
    return min(res,sum-res)
    
}

func min(a,b int) int {
    if(a<b) {
        return a
    }
    return b
}

func max(a,b int) int {
    if(a>b) {
        return a
    }
    return b
}

```
