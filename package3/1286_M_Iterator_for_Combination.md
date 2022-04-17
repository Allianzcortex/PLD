
Problem descritpion:

```

Design the CombinationIterator class:

CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
next() Returns the next combination of length combinationLength in lexicographical order.
hasNext() Returns true if and only if there exists a next combination.
 

Example 1:

Input
["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[["abc", 2], [], [], [], [], [], []]
Output
[null, "ab", true, "ac", true, "bc", false]

Explanation
CombinationIterator itr = new CombinationIterator("abc", 2);
itr.next();    // return "ab"
itr.hasNext(); // return True
itr.next();    // return "ac"
itr.hasNext(); // return True
itr.next();    // return "bc"
itr.hasNext(); // return False
 

Constraints:

1 <= combinationLength <= characters.length <= 15
All the characters of characters are unique.
At most 104 calls will be made to next and hasNext.
It's guaranteed that all calls of the function next are valid.

```

Basic idea:

这道题关键是求 next combination，自己提供一种解法吧，是提前生成 pre-calculate
所有的组合，然后直接返回结果，对应的 Python 代码如下：

```Python

class CombinationIterator:

    def __init__(self, characters: str, combinationLength: int):
        self.queue = []
        self._get_all_combinations("",0,characters,combinationLength)
        self.index = 0
    
    def _get_all_combinations(self,res,index,characters,length):
        if len(res)==length:
            self.queue.append(res)
        for i in range(index,len(characters)):
            self._get_all_combinations(res+characters[i],i+1,characters,length)

    def next(self) -> str:
        self.index += 1
        return self.queue[self.index-1]

    def hasNext(self) -> bool:
        
        return self.index<=len(self.queue)-1

```

其中有一个方法是用 `stack` 来存储当前的 combination，是比较好的一个结果，后续再看吧

链接在此：https://leetcode.com/problems/iterator-for-combination/discuss/451544/Java-No-pre-calculation-needed-for-iterator-questions

其他 bitmask 或者之类的方法暂时先不看