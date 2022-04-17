
Problem description:

```
Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
 

Constraints:

1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].

```

Basic idea:

这道题类似于 26 进制转化

Go 解法如下：

```Golang

func titleToNumber(columnTitle string) int {
    res:=0
    
    for i:=0;i<len(columnTitle);i++ {
        num := int(columnTitle[i]-'A')+1
        res = res*26 + num
    }
    
    return res
}

```