
Problem description:

```

Description
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],…] (si < ei), find the minimum number of conference rooms required.

Sample I/O
Example 1
Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2
Input: [[7,10],[2,4]]
Output: 1

```

Basic Idea :

1. 根据 start time 来排序

2. 当添加一个新的会议时，使用最小堆来存储并判断是否前一个 meeting 已经结束

Java 解法如下：

```Java

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->(o1[0]-o2[0]));
        int count=0;
        // Minheap is default
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] item:intervals) {
            if(ps.isEmpty()) {
                count+=1;
                pq.offer(item[1]);
            } else {
                if(pq.peek()<=item[0]) {
                    pq.poll();
                } else {
                    count+=1;
                }
                pq.offer(item[1]);
            }
        }
        
        return count;
    }
}

```

Python 解法如下，就不用 count 了而是用 heap 压入值

```Python

def minMeetingRooms(self, intervals: List[List[int]]) -> int:
    size = len(intervals)
    count = 0
    heap = []

    for interval in sorted(intervals):
        if head and interval[0]>=heap[0]:
            heapq.heappushpop(heap,interval[1])
        else:
            heapq.heappush(heap,interval[1])
    
    return len(heap)

```