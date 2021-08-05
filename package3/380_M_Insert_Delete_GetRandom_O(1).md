
Problem description :

```

Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

 

Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 

Constraints:

-231 <= val <= 231 - 1
At most 2 * 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.

```


Idea :

这道题要求是在 O(1) 时间里来实现 add/insert/delete 操作

注意在 Python dict{} 里检测一个 key 是否存在 `if key in dict` 的时间复杂度是 O(1)

思路是用一个 list() 和一个 map() 来做存储：

对 `增加`:

- 每次把新的值添加到最后，并用一个 map{} 来存储 val 和对应的 index

对 `删除`:

- 每次都要把对应的这个值放到 list() 的最后，需要这么做：

a) 首先用 map.pop(val) 得到 index
b) 用 list[-1] 得到 last_val
c) 更新 map, set[index] = last_val
d) 更新 map，map[last_val] = index

最后统一 set.pop()


Python Solution :

```Python

class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.set = []
        self.map = {}
        

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        
        if val not in self.map:
            self.set.append(val)
            self.map[val] = len(self.set)-1
            return True
        else:
            return False
        

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        
        if val in self.map:
            index = self.map.pop(val)

            if index<len(self.set)-1:
                # move this val to end of set
                lastVal = self.set[-1]
                self.set[index] = lastVal
                self.map[lastVal] = index
            self.set.pop()
            return True
        else:
            return False

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        from random import randint
        
        return self.set[randint(1,len(self.set))-1]

```

