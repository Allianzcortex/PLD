
Problem description:

```

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 

Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?

```

Basic idea:

这道题是要用两个 heap 来存储：

其中 min_heap 存储前一半小的数据，max_heap 存储后一半大的数据。
如果数的长度为偶数，那么各存储一半；
取 median 值时从最小堆取得最大值，从最大堆取得最小值，加起来除以 2.
为了维持这个顺序，如果之前有奇数个，要加入一个新值，要保证数的顺序，需要先往 max_heap
里插入这个新值，再从 max_heap 里弹出最小的值向 min_heap 中插入。

如果数的长度为奇数，那么 min_heap 存储 n//2 个数，max_heap 存储 n//2+1 个数
取 median 值时从最大堆取最小值
为了维持这个顺序，如果之前有偶数个，要加入一个新值，要保证数的顺序，需要先往 min_heap
里插入这个新值，再从 min_heap 里弹出最大的值向 max_heap 中插入。

所以 min_heap 需要是一个最大堆，而 max_heap 需要是一个最小堆

Python 代码如下：

```Python
class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        
        self.min_heap = []
        self.max_heap = []
        self.is_even = True
        

    def addNum(self, num: int) -> None:
        if self.is_even:
            """
            min_heap keep the same length
            max_heap plus 1
            """
            # heappush(self.min_heap,-1*num)
            # prev_val = -1*heappop(self.min_heap)
            # heappush(self.max_heap,prev_val)
            # 下面的语句等价于上面三条
            heappush(self.max_heap,-1*heappushpop(self.min_heap,-1*num))
        else:
            """
            max_heap keep the same length
            min_heap plus 1
            """
            # heappush(self.max_heap,num)
            # prev_val = -1*heappop(self.max_heap)
            # heappush(self.min_heap,prev_val)
            # 下面的语句等价于上面三条
            heappush(self.min_heap,-1*heappushpop(self.max_heap,num))
        
        self.is_even = not self.is_even
        

    def findMedian(self) -> float:
        if self.is_even:
            return (self.max_heap[0]-self.min_heap[0])/2
        else:
            return self.max_heap[0]

```

