
Problem description:

```

Design a data structure to find the frequency of a given value in a given subarray.

The frequency of a value in a subarray is the number of occurrences of that value in the subarray.

Implement the RangeFreqQuery class:

RangeFreqQuery(int[] arr) Constructs an instance of the class with the given 0-indexed integer array arr.
int query(int left, int right, int value) Returns the frequency of value in the subarray arr[left...right].
A subarray is a contiguous sequence of elements within an array. arr[left...right] denotes the subarray that contains the elements of nums between indices left and right (inclusive).

 

Example 1:

Input
["RangeFreqQuery", "query", "query"]
[[[12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]], [1, 2, 4], [0, 11, 33]]
Output
[null, 1, 2]

Explanation
RangeFreqQuery rangeFreqQuery = new RangeFreqQuery([12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56]);
rangeFreqQuery.query(1, 2, 4); // return 1. The value 4 occurs 1 time in the subarray [33, 4]
rangeFreqQuery.query(0, 11, 33); // return 2. The value 33 occurs 2 times in the whole array.
 

Constraints:

1 <= arr.length <= 105
1 <= arr[i], value <= 104
0 <= left <= right < arr.length
At most 105 calls will be made to query

```

Basic idea:

这道题是 range query 题，但求的是 frequency，所以反而不需要用
`TreeMap` 这样复杂的数据结构

思路是用二分搜索，把所有 val 出现的 index 都用 list 存储，然后
二分搜索搜索 left/right 的值，所得到的 index 相减就是该值出现的
频率

比如 `indexes=[3,9,12]`：

bisect_left 是寻找第一个出现的小于或等于 target 的 insert index，所以 `bisect_left(indexes,9)=1` 且 `bisect_left(indexes,3)=0`

bisect_right 是寻找第一个出现的大于 target 的 insert index，所以 `bisect_right(indexes,11)=2` 且 `bisect_right(indexes,13)=3`

即对 `[i...j]`，bisect_left(arr,i) 找到的是 [0..i) 里 target 的数量
而 bisect_right(arr,j) 找到的是 [0..j] 里 target 的数量，二者相减
就是 [i..j] 里的数量，也是我们需要的值

Python 解法如下：

```Python

class RangeFreqQuery:

    def __init__(self, arr: List[int]):

        self.indexes = defaultdict(list)
        for i,val in enumerate(arr):
            self.indexes[val].append(i)

    def query(self, left: int, right: int, value: int) -> int:

        left_cnt = bisect.bisect_left(self.indexes[value],left)
        right_cnt = bisect.bisect_right(self.indexes[value],right)
        
        return right_cnt - left_cnt

```