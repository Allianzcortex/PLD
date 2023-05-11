
Category : 

1. Arrays & Hashing


---


2. Two Pointers

2.1 125 E Valid Palindrome E https://leetcode.com/problems/valid-palindrome-ii/

注意转化大小写，以及比较之后为防止无限循环 left+=1,right-=1

2.2 680 E Valid PalindromeII E https://leetcode.com/problems/valid-palindrome-ii/

可以去除最多一个字符，那么就是 (left+1,right) 和 (left,right-1) 两种操作，同时考虑到
最多可以这么做一次，就把 replace_count 写入函数参数中进行比较

2.3 1984 E Minimum DIfference Between Heighest and Lowest ok K scores https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

基本思路是先排序然后比较所有可能的 k 个选择的所有情况，就是设置一个长度为 K 的 window，从小到大套过去，
每套一次就更新一下最大值

2.4 344 E Reverse String https://leetcode.com/problems/reverse-string/

逆转字符串，就是最基本不过的 2-pointers 应用

2.5 Merge Sorted Array

2.7 Remove Duplicates from Softed Array (easy 题之后统一处理)

2.6 283 E Move Zeroes https://leetcode.com/problems/move-zeroes/

这道题把所有的 0 往后排，其他的数字保持原有顺序，就是很经典的两个指针 left 和 right，right 一直往后移
一直到发现第一个不为 0 的元素，然后和 left 交换位置。如果 left 本身不为 0，那么数组被保持；如果 left 为
0，那么实现交换的效果。

2.8 80 M Remove Duplicates from Sorted Array II 

这道题有一定难度哎，关键是临场要一次写对。定义两个指针 left 和 right，关键是想清对数组的
前两个元素，left 和 right 一定是贴在一起的，对第三个元素，如果 nums[right]==nums[left-2]，那么就意味着当前 right 这边
已经出现了 3 个连续的元素，right 要 +=1。如果 nums[right]!=nums[left-2]，那么就把 right 的值赋给 left 然后两者都向右移动

2.9 167 M Two Sum II - Input Array Is Sorted

虽然给了 Medium tag，但应该是 easy 难度，就是求出最小值和最大值之和，然后比较 target，进一步决定
是要 left ++ 还是要 right --

2.10 15 M 3Sum 

用到了 167 的思路，先排序后找 pair，但注意不能包含重复元素，所以对返回元素 (i,j,k)
既要对 i 去重，也要对 j&k 去重