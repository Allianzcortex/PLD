
Problem description:

```

The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 

Constraints:

1 <= s.length <= 105
s[i] is either 'A', 'C', 'G', or 'T'.

```

Basic idea:

一种非常没有效率的 Python 解法如下：

```Python

class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        length = len(s)
        
        if length<=10:
            return []
        
        visited = defaultdict(lambda:0)
        
        for i in range(10,length+1):
            substr = s[i-10:i]
            visited[substr]+=1
        
        return [val for val,count in visited.items() if count>1]

```

这种解法无法应对后续的 follow-up : 比如长度更长怎么办