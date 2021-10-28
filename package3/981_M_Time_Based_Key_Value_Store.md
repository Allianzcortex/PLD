
Problem description:

```

Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 

Example 1:

Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"
 

Constraints:

1 <= key.length, value.length <= 100
key and value consist of lowercase English letters and digits.
1 <= timestamp <= 107
All the timestamps timestamp of set are strictly increasing.
At most 2 * 105 calls will be made to set and get.


```

Basic idea:

因为已经说了 timestamp 是严格递增，所有这就可以很好地用 binary search 来解。
其中关于为什么最后返回 `return arr[right][0]` 因为在 loop break 以前很明显的
前提条件是 left==right==middle，这时候：

1. arr[middle]>timestamp，那么 right = middle-1，arr[right]是恰好满足条件的前一个 timestamp

2. arr[middle]< timestamp，那么 left = middle+1，arr[right]也恰好是满足条件的前一个 timestamp

所以 right 就是我们最后需要的 index.
       
Python 解法如下：

```Python

class TimeMap:

    def __init__(self):
        
        self.dic = defaultdict(list)
        
    def set(self, key: str, value: str, timestamp: int) -> None:
        
        self.dic[key].append([value,timestamp])

    def get(self, key: str, timestamp: int) -> str:
        
        arr = self.dic[key]
        left,right = 0,len(arr)-1
        
        # pre-check
        if not arr or arr[left][1]>timestamp:
            return ""

        while left<=right:
            middle = left+(right-left)//2
            
            if arr[middle][1]<timestamp:
                left = middle +1
            elif arr[middle][1]>timestamp:
                right = middle-1
            else:
                return arr[middle][0]
        
        return arr[right][0]

```

