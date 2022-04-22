
Problem description:

```
A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].

 

Example 1:

Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation: 
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.
Example 2:

Input: heights = [5,1,2,3,4]
Output: 5
Explanation:
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.
Example 3:

Input: heights = [1,2,3,4,5]
Output: 0
Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.
 

Constraints:

1 <= heights.length <= 100
1 <= heights[i] <= 100

```

Basic idea:

这道题题意很简单，最直观的就是排序然后比较，这样的时间复杂度是：
O(nlogn)+O(n)

```Python
class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        
        res = 0
        for index,num in enumerate(sorted(heights)):
            if num!=heights[index]:
                res += 1
        
        return res

```

更进一步的解法是用 count 的思想，也就是按照 frequency 统计，
之后设 curHeight 为 0 然后从小到大开始，间接起到了排序的作用

```Golang

func heightChecker(heights []int) int {
    
    frequency := make(map[int]int)
    
    for _,height := range heights {
        frequency[height]+=1
    }
    
    count,curHeight := 0,0
    
    for i:=0;i<len(heights);i++ {
        for frequency[curHeight]==0 {
            curHeight += 1
        }
        
        if curHeight!=heights[i] {
            count += 1
        }
        frequency[curHeight]-=1
    }
    
    return count
    
}

```