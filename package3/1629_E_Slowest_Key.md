
Problem description:

```
A newly designed keypad was tested, where a tester pressed a sequence of n keys, one at a time.

You are given a string keysPressed of length n, where keysPressed[i] was the ith key pressed in the testing sequence, and a sorted list releaseTimes, where releaseTimes[i] was the time the ith key was released. Both arrays are 0-indexed. The 0th key was pressed at the time 0, and every subsequent key was pressed at the exact time the previous key was released.

The tester wants to know the key of the keypress that had the longest duration. The ith keypress had a duration of releaseTimes[i] - releaseTimes[i - 1], and the 0th keypress had a duration of releaseTimes[0].

Note that the same key could have been pressed multiple times during the test, and these multiple presses of the same key may not have had the same duration.

Return the key of the keypress that had the longest duration. If there are multiple such keypresses, return the lexicographically largest key of the keypresses.

 

Example 1:

Input: releaseTimes = [9,29,49,50], keysPressed = "cbcd"
Output: "c"
Explanation: The keypresses were as follows:
Keypress for 'c' had a duration of 9 (pressed at time 0 and released at time 9).
Keypress for 'b' had a duration of 29 - 9 = 20 (pressed at time 9 right after the release of the previous character and released at time 29).
Keypress for 'c' had a duration of 49 - 29 = 20 (pressed at time 29 right after the release of the previous character and released at time 49).
Keypress for 'd' had a duration of 50 - 49 = 1 (pressed at time 49 right after the release of the previous character and released at time 50).
The longest of these was the keypress for 'b' and the second keypress for 'c', both with duration 20.
'c' is lexicographically larger than 'b', so the answer is 'c'.
Example 2:

Input: releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
Output: "a"
Explanation: The keypresses were as follows:
Keypress for 's' had a duration of 12.
Keypress for 'p' had a duration of 23 - 12 = 11.
Keypress for 'u' had a duration of 36 - 23 = 13.
Keypress for 'd' had a duration of 46 - 36 = 10.
Keypress for 'a' had a duration of 62 - 46 = 16.
The longest of these was the keypress for 'a' with duration 16.

```

Basic Idea :

这道题的描述很简单，非常直观：

不过自己一开始因为模拟真实面试，考虑的还是不够周到，所以把问题复杂化了：

用了一个 dict 来存储所有距离

```Python

class Solution:
    def slowestKey(self, releaseTimes: List[int], keysPressed: str) -> str:
        
        if not releaseTimes or not keysPressed:
            return ""
        
        """
        1. calculate each duration for each key,and store duration in a map with format : {duration:[key1,key2...]}
        2. store the max duration
        3. retrieve the max duration list and sort it
        """
        
        res,maxDuration = defaultdict(list),0
        
        for i in range(len(releaseTimes)):
            if i==0:
                duration = releaseTimes[i]
            else:
                duration = releaseTimes[i]-releaseTimes[i-1]
            
            res[duration].append(keysPressed[i])
            maxDuration = max(maxDuration, duration)
        
        return sorted(res[maxDuration])[-1]

```

但其实空间复杂度可以达到 O(1),只要用一个变量来存储就好 ：

```Python

class Solution:
    def slowestKey(self, releaseTimes: List[int], keysPressed: str) -> str:
        
        time,char = releaseTimes[0],keysPressed[0]
        
        for i in range(1,len(keysPressed)):
            duration = releaseTimes[i] - releaseTimes[i-1]
            if duration>time or (duration==time and keysPressed[i]>char):
                char = keysPressed[i]
                time = duration
        
        return char

```
