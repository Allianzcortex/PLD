
Basic Idea is :

1. sort the array based on start time
2. use a minheap to store and judge whether a previous meeting is finished
when we try to add a new meeting.

Solution still not Validated yet

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