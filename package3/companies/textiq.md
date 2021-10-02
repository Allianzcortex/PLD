
Basic idea :

textiq 基本有 3 道 OA 题：

```
1. Lexicographically all Shortest Palindromic Substrings from a given string
2. Given a BST, replace each node's value with the sum of the values of all the nodes that are greater than that ‍‌‍‍‌‌‌‌‍‍‍‍‍‍‍‍‍‍‍‍node.
3. Find a Sum of Fractions
```

对应的可能题目是：


---

第一道题目对应的是：

https://www.geeksforgeeks.org/lexicographically-all-shortest-palindromic-substrings-from-a-given-string/

直接用 Python 的 `sorted(set(s))` 就可以得到结果，或者用 array[26]
然后 `ord(ch)-ord('a')` 得到 index

---


第二道题目对应的是：

LC 的这道题

1038. Binary Search Tree to Greater Sum Tree

https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

√ 基本思路是用 reverse inorder traverse 在遍历树的过程中加入新的值

---

第三道题目对应的是：

可能的 LC 题目：

592 Fraction Addition and Subtraction

https://leetcode.com/problems/fraction-addition-and-subtraction/

对应的解法是：

1. 按照 `+/-` 来分割得到分子
2. 按照分数加减法来计算
3. 最后根据 `gcd` 得到最大公约数来化简


