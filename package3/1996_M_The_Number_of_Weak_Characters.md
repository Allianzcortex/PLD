
Probldem description:

```
You are playing a game that contains multiple characters, and each of the characters has two main properties: attack and defense. You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents the properties of the ith character in the game.

A character is said to be weak if any other character has both attack and defense levels strictly greater than this character's attack and defense levels. More formally, a character i is said to be weak if there exists another character j where attackj > attacki and defensej > defensei.

Return the number of weak characters.

 

Example 1:

Input: properties = [[5,5],[6,3],[3,6]]
Output: 0
Explanation: No character has strictly greater attack and defense than the other.
Example 2:

Input: properties = [[2,2],[3,3]]
Output: 1
Explanation: The first character is weak because the second character has a strictly greater attack and defense.
Example 3:

Input: properties = [[1,5],[10,4],[4,3]]
Output: 1
Explanation: The third character is weak because the second character has a strictly greater attack and defense.

```

Basic idea :

自己一开始也想到了排序，但自己的解法是这样的：

```Python
class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        
        properties.sort(key = lambda x:(x[0],x[1]))
        
        res = 0
        
        for item in properties[:-1]:
            if item[0]<properties[-1][0] and item[1]<properties[-1][1]:
                res += 1
        
        return res

```

这显然不对，因为根据上述的排序，其实是可以找到一个元素不在最后但比 item 严格大的。

如果自己再做一遍的话思路应该是这样：

a. 肯定是要排序，并且按照 x 坐标由小到大排序
b. 然后从后往前遍历，维护一个 maxY 坐标，只要当前元素小于 maxY，就说明一定有
一个 Y 满足要求
c. 然后考虑 x 坐标相等情况。比如 [1,3]和[1,5] 如果排序后的顺序是 [1,3]->[1,5]，
然后我们从后往前遍历，发现到了 [1,5] 这里 maxY 是 5，然后对 [1,3] 来说 y<maxY，但
我们知道这应该是不满足条件的
d. 如果上面的情况再考虑 x 轴的话情况会更复杂
e. 我们要做的是确保，只要 x 轴相等，那么两个元素永远也不可能 strictly greater
所以按照 `(x[0],-x[1])` 排序，那么对 [1,3]和[1,5]，排序顺序就变为 [1,5]->[1,3]
从后往前遍历，对 [1,5] 来说，如果 maxY > 3，则说明在 [1,3] 之后存在 strictly greater
的元素，应该 +1。如果 maxY == 3，则说明在 [1,3] 之后不存在 y>3 的元素，而因为
5<3，那么必然不 strictly greater

对应的 Python 解法如下：

```Python

class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:

        properties.sort(key = lambda x:(x[0],-x[1]))
        
        res = 0
        max_d = -float('inf')
        n = len(properties)
        
        for item in properties[::-1]:
            if item[1]<max_d:
                res += 1
            max_d = max(max_d,item[1])
        
        return res

```

真是很巧妙的思路，不知道能否面试时解释清楚