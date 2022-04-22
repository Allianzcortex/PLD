
Problem description:

```

Given two strings first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

Return an array of all the words third for each occurrence of "first second third".

 

Example 1:

Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]
Example 2:

Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]
 

Constraints:

1 <= text.length <= 1000
text consists of lowercase English letters and spaces.
All the words in text a separated by a single space.
1 <= first.length, second.length <= 10
first and second consist of lowercase English letters.

```

Basic idea:

这道题很直观了，真的就是 easy 难度可以直接比较的题目，Golang 解法如下

```Golang

func findOcurrences(text string, first string, second string) []string {
    
    // res:=make([]string,0)
    // 或者用另一种方式来定义 slice
    res:=[]string{}
    
    input:=strings.Split(text," ")
    for i:=0;i<len(input)-2;i++ {
        if input[i]==first && input[i+1]==second {
            res = append(res,input[i+2])
        }
    }
    
    return res
}

```