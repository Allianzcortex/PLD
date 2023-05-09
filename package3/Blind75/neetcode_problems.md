
Category : 

1. Arrays & Hashing


---


2. Two Pointers

2.1 125 Valid Palindrome E https://leetcode.com/problems/valid-palindrome-ii/

注意转化大小写，以及比较之后为防止无限循环 left+=1,right-=1

2.2 680 Valid PalindromeII E https://leetcode.com/problems/valid-palindrome-ii/

可以去除最多一个字符，那么就是 (left+1,right) 和 (left,right-1) 两种操作，同时考虑到
最多可以这么做一次，就把 replace_count 写入函数参数中进行比较

2.3 1984 Minimum DIfference Between Heighest and Lowest ok K scores https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

基本思路是先排序然后比较所有可能的 k 个选择的所有情况，就是设置一个长度为 K 的 window，从小到大套过去，
每套一次就更新一下最大值

2.4 344 Reverse String https://leetcode.com/problems/reverse-string/

逆转字符串，就是最基本不过的 2-pointers 应用