
Problem description:

```

Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of candies of the jth box of candy that Bob has.

Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box they have.

Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange, and answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer exists.

 

Example 1:

Input: aliceSizes = [1,1], bobSizes = [2,2]
Output: [1,2]
Example 2:

Input: aliceSizes = [1,2], bobSizes = [2,3]
Output: [1,2]
Example 3:

Input: aliceSizes = [2], bobSizes = [1,3]
Output: [2,3]
Example 4:

Input: aliceSizes = [1,2,5], bobSizes = [2,4]
Output: [5,4]
 

Constraints:

1 <= aliceSizes.length, bobSizes.length <= 104
1 <= aliceSizes[i], bobSizes[j] <= 105
Alice and Bob have a different total number of candies.
There will be at least one valid answer for the given input.

```

Basic idea:

首先是找到数学规律：

假设 alice 现在有 sum_a 个糖果，bob 有 sum_b 个糖果，
alice 要交换的糖果是 a1，bob 要交换的糖果是 b1，
那么就满足如下的条件：`sum_a-a1+b1=sum_b-b1+a1`
合并后为：`a1-ab1 = (sum_a-sum_b)//2`

这时就很清晰了，先排序然后依次比较看是否满足上述的条件

```Python

class Solution:
    def fairCandySwap(self, aliceSizes: List[int], bobSizes: List[int]) -> List[int]:

        gap = (sum(aliceSizes)-sum(bobSizes))//2
        aliceSizes.sort()
        bobSizes.sort()
        
        for val in aliceSizes:
            if val-gap in bobSizes:
                return [val,val-gap]

```