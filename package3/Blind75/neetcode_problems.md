
Category : 

1. Arrays & Hashing


---


2. Two Pointers

2.1 Valid Palindrome E https://leetcode.com/problems/valid-palindrome-ii/
注意转化大小写，以及比较之后为防止无限循环 left+=1,right-=1

2.2 Valid PalindromeII E https://leetcode.com/problems/valid-palindrome-ii/
可以去除最多一个字符，那么就是 (left+1,right) 和 (left,right-1) 两种操作，同时考虑到
最多可以这么做一次，就把 replace_count 写入函数参数中进行比较