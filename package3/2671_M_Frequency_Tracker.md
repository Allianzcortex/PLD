
Problem description:

```

Design a data structure that keeps track of the values in it and answers some queries regarding their frequencies.

Implement the FrequencyTracker class.

FrequencyTracker(): Initializes the FrequencyTracker object with an empty array initially.
void add(int number): Adds number to the data structure.
void deleteOne(int number): Deletes one occurence of number from the data structure. The data structure may not contain number, and in this case nothing is deleted.
bool hasFrequency(int frequency): Returns true if there is a number in the data structure that occurs frequency number of times, otherwise, it returns false.
 

Example 1:

Input
["FrequencyTracker", "add", "add", "hasFrequency"]
[[], [3], [3], [2]]
Output
[null, null, null, true]

Explanation
FrequencyTracker frequencyTracker = new FrequencyTracker();
frequencyTracker.add(3); // The data structure now contains [3]
frequencyTracker.add(3); // The data structure now contains [3, 3]
frequencyTracker.hasFrequency(2); // Returns true, because 3 occurs twice

Example 2:

Input
["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
[[], [1], [1], [1]]
Output
[null, null, null, false]

Explanation
FrequencyTracker frequencyTracker = new FrequencyTracker();
frequencyTracker.add(1); // The data structure now contains [1]
frequencyTracker.deleteOne(1); // The data structure becomes empty []
frequencyTracker.hasFrequency(1); // Returns false, because the data structure is empty

Example 3:

Input
["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
[[], [2], [3], [1]]
Output
[null, false, null, true]

Explanation
FrequencyTracker frequencyTracker = new FrequencyTracker();
frequencyTracker.hasFrequency(2); // Returns false, because the data structure is empty
frequencyTracker.add(3); // The data structure now contains [3]
frequencyTracker.hasFrequency(1); // Returns true, because 3 occurs once

 

Constraints:

1 <= number <= 105
1 <= frequency <= 105
At most, 2 * 105 calls will be made to add, deleteOne, and hasFrequency in total.

```

Basic Idea:

一道很不错的设计问题，用 2 个 dict 来存储：

一个 dict 存储 {num:freq} 来计算某个 num 的出现次数
一个 dict 存储 {freq:count} 来计算某个出现频率的数量

Python 解法如下：

```Python

class FrequencyTracker:

    def __init__(self):
        self.freq = defaultdict(int)
        self.num2freq = defaultdict(int)
        
    
    def add(self, number: int) -> None:
        original_freq = self.freq[number]
        self.freq[number] = original_freq + 1
        self.num2freq[original_freq] -= 1
        self.num2freq[original_freq + 1] += 1

    def deleteOne(self, number: int) -> None:
        if self.freq[number]==0:
            return 
        original_freq = self.freq[number]
       
        self.freq[number] = original_freq - 1
        # remove original frequency occurences, and add new frequency occurences
        self.num2freq[original_freq] -= 1
        self.num2freq[original_freq - 1] += 1

    def hasFrequency(self, frequency: int) -> bool:
        
        return self.num2freq[frequency] > 0

```

TODO: 添加 Golang 解法