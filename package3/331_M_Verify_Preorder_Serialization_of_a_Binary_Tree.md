
Problem description:

```

One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as '#'.


For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.

Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.

It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid.

For example, it could never contain two consecutive commas, such as "1,,3".
Note: You are not allowed to reconstruct the tree.

 

Example 1:

Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true
Example 2:

Input: preorder = "1,#"
Output: false
Example 3:

Input: preorder = "9,#,#,1"
Output: false

```

Idea : 这道题第一次看起来有无从下手的感觉，但细想的话就知道
应该用 Stack 的。

具体思路如下：

1. 遇到一个数字（非 null 节点)，压入

2. 遇到一个 # : 分类讨论

2.1 如果这时候 stack.peek() 不是 '#'，就说明这个 # 是一个为 null 的左节点，压入

2.1 如果这个时候 stack.peek() 是 '#'，根据 2.1 的情况，说明这个 # 是一个为 null 的右节点，
然后可以开始玩消消乐，只有 stack 不为空且 stack.peek() 是 '#'，就可以一直消。注意每消掉一个
subtree 后要用一个 '#' 来代替，方便后续操作

```
preorder = 1,2,3,#,#,#,#

Pass 1: stack = [1]

Pass 2: stack = [1,2]

Pass 3: stack = [1,2,3]

Pass 4: stack = [1,2,3,#]

Pass 5: stack = [1,2,3,#,#] -> two #s on top so pop them and replace top with #. -> stack = [1,2,#]

Pass 6: stack = [1,2,#,#] -> two #s on top so pop them and replace top with #. -> stack = [1,#]

Pass 7: stack = [1,#,#] -> two #s on top so pop them and replace top with #. -> stack = [#]

If there is only one # on stack at the end of the string then return True else return False.

```

Python 代码如下：

```Python

class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        
        preorder,stack = preorder.split(","),[]
        
        for ch in preorder:
            
            # case 1
            if ch!='#':
                stack.append(ch)
            else:
                while ch=='#' and stack and stack[-1]=='#':
                    stack.pop()
                    if not stack:
                        return False
                    stack.pop()
                stack.append(ch)
        
        return stack == ['#']

```

用经典的 :

```
     1
  /     \
 2       3

[1,2,#,#,3,#,#]
```
来解释：

```
1. 遇到 1 ,压入，此时 s=[1]
2. 遇到 2 ,压入，此时 s=[1,2]
3. 遇到 #, stack.peek()=2!='#'，压入，此时 s=[1,2,#]
4. 遇到 #, stack.peek()='#',进入 while 循环：
4.1 第一轮 while 循环后 s=[1]，不满足进入第二轮的条件，再根据代码压入 ch
    s 最终变为 [1,#]
5. 遇到 3，压入，此时 s=[1,#,3]
6. 遇到 #,stack.peek=3!='#'，压入，此时 s=[1,#,3,#]
7. 遇到 #,stack.peek()='#'，进入 while 循环：
7.1 第一轮 while 循环后 s=[1,#]，满足进入第二轮的条件，继续循环
7.2 第二轮 while 循环后 s=[]，不满足继续进入下一轮的条件，再根据代码压入 ch
   s 最终变为 [#]

```